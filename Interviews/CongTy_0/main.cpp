#include <iostream>
#include <cstdlib>
#include <fstream>
#include <sstream>
#include <vector>
#include <cstring>
#include <algorithm>
#include <queue>
#include <functional>
#include <ctime>

using namespace std;

//-------- Global Variables -----------
//! Sample data
char* pInputFileName = "input.txt";
char* pOutputFileName = "output.txt";
string strChunkFilePrefix = "chunk_";
string strOutputFilePrefix = "output_";
int RAM_SIZE = 1 << 20; // TEST: Ram=1MB, File=10M
// int RAM_SIZE = 40; 
struct StringNode
{
    string* data;
    int index;    
    StringNode(string* data, int index){
        this->data = data;
        this->index = index;
    }
};

class ChunkFile{
private:
    ifstream inputStream;
    int BATCH_SIZE;
    int currentIndex;
    vector<string*> strArray;

private:
    bool loadNextBatch(){
        if(inputStream.is_open() == false)
            return false;
        if(inputStream.eof())
            return false;
        // clear previous data
        for (size_t i = 0; i < strArray.size(); i++){
            delete strArray[i];
        }
        strArray.clear();
        
        // Load new data
        string temp;
        int byteCount = 0;
        while(getline(inputStream, temp)){
            byteCount += temp.size();
            string* newLine = new string(temp);
            strArray.push_back(newLine);
            if(byteCount >= BATCH_SIZE) 
                break;
        }  

        // reset current index
        currentIndex = 0;
        return true;
    }

public:
    void load(int index, int maxBuffer){
        this->BATCH_SIZE = maxBuffer;

        stringstream ss;
        index++;
        ss << strChunkFilePrefix << index << ".txt";
        string strFileName = ss.str();
        inputStream.open(&strFileName[0], fstream::in);
        currentIndex = 0;
        srand(time(NULL));
    }


    string* getNextLine(){
        if(currentIndex + 1 < strArray.size()){ // load next line
            currentIndex++;
            return strArray[currentIndex];
        }else if(loadNextBatch()){ // load next batch
            if(currentIndex < strArray.size())
               return strArray[currentIndex];
        }
        return NULL;
    }
};

/**
 * Split input file to many chunks (with ramSize).
 * Sort each chunk and save to file
 * return: number of chunks
 **/
int splitSortThenSave(char *pInputFileName, int ramSize);
/**
 * Sort the chunk and save to file
 */
int sortThenSaveChunkFile(int index, vector<string*>& chunk);


int kWayMerge(int k, int ramSize, char *pOutputFileName);

int getBatchFromChunk(int batchIndex, vector<string*>& batch, ifstream& trunkFile);

/**
 * For sort vector<string*>
 **/
bool compareStringPointers(string *s1, string *s2);
class CompareStringPointers{
public:
    bool operator() (const string* s1, const string* s2) const{
        return (*s1).compare((*s2)) > 0;
    }
};

class CompareStringNode{
public:
    bool operator() (const StringNode& s1, const StringNode s2) const{
        return (*s1.data).compare((*s2.data)) > 0;
    }
};


int main(int argc, char *argv[])
{
    //! Ignore validate the input for now
    if(argc > 1){
        pInputFileName = argv[1];
        pOutputFileName = argv[2];
        RAM_SIZE = atoi(argv[3]);
    }

    cout << "input(" << pInputFileName << ") output(" << pOutputFileName << ") RamSize(" << RAM_SIZE << ")" << endl;
    
    int numberOfChunks = splitSortThenSave(pInputFileName, RAM_SIZE);
    if(numberOfChunks > 0) {
        kWayMerge(numberOfChunks, RAM_SIZE, pOutputFileName);
    } else {
        cout << "Error: There is something wrong!" << endl;
    }

    return 0;
}


bool compareStringPointers(string *s1, string *s2)
{
    int r = (*s1).compare(*s2);
    return r < 0 ? true : false;
}

int splitSortThenSave(char *pInputFileName, int maxFileSize)
{
    ifstream inputStream(pInputFileName);
    int chunkCount = 0;

    if(inputStream.is_open())
    {
        int byteCount = 0;
        string strLine;
        vector<string*> vecChunks;
        
        while(getline(inputStream, strLine))
        {
            string *pLine = new string(strLine);
            if(byteCount + pLine->size() > maxFileSize)
            {
                // finish previous 
                byteCount = 0;
                chunkCount++;
                sortThenSaveChunkFile(chunkCount, vecChunks);
                vecChunks.clear();
            }
            
            // continues as normal
            byteCount += pLine->size();
            vecChunks.push_back(pLine);
        }

        if(vecChunks.size() > 0)
        {
            // Thu hien xu ly not lan cuoi
            chunkCount++;
            sortThenSaveChunkFile(chunkCount, vecChunks);
            vecChunks.clear();
        }

        inputStream.close();
    
        return chunkCount;
    }
    
    return -1;
}

int sortThenSaveChunkFile(int index, vector<string*>& chunk)
{
    stringstream ss;
    ss << strChunkFilePrefix << index << ".txt";
    string strFileName = ss.str();
    ofstream outputStream(&strFileName[0]);

    sort(chunk.begin(), chunk.end(), compareStringPointers);

    for (size_t i = 0; i < chunk.size(); i++)
    {
        string* pLine = chunk[i];
        outputStream << (*pLine) << endl;
        delete pLine;
    }

    cout << strFileName << " created! " << endl;
    outputStream.close();
    return 0;
}

int kWayMerge(int k, int ramSize, char *pOutputFileName)
{
    //! Special case
    if(k == 1){
        stringstream chunkFile;
        chunkFile << strChunkFilePrefix << k << ".txt";
        rename(&chunkFile.str()[0], pOutputFileName);
        return 0;
    }

    //! Canculate number of byte should be use in each chunk
    const int BATCH_SIZE = (ramSize) / k;
    cout << "BATCH_SIZE: " << BATCH_SIZE << endl;

    ofstream outputStream(pOutputFileName, fstream::out);
    priority_queue< StringNode, vector<StringNode>, CompareStringNode > minHeapBuffer;
    ChunkFile* chunkFiles = new ChunkFile[k];


    for (size_t i = 0; i < k; i++)
    {
        chunkFiles[i].load(i, BATCH_SIZE);
    }

    for (size_t i = 0; i < k; i++)
    {
        string* firstLine = chunkFiles[i].getNextLine();
        if(firstLine != NULL){
            StringNode newNode(firstLine, i);
            minHeapBuffer.push(newNode);
        }
    }

    while(minHeapBuffer.empty() == false)
    {
        StringNode minNode = minHeapBuffer.top();
        outputStream << *minNode.data << '\n';
        minHeapBuffer.pop();

        string* newLine = chunkFiles[minNode.index].getNextLine();
        if(newLine != NULL){
            StringNode newNode(newLine, minNode.index);
            minHeapBuffer.push(newNode);
        }
    }
    
    delete[] chunkFiles;
    return 0;
}

int getBatchFromChunk(int batchIndex, vector<string*>& batch, ifstream& trunkFile)
{
    return 0;
}