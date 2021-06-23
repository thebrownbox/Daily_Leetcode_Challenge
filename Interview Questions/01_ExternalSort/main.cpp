#include <iostream>
#include <cstdlib>
#include <fstream>
#include <sstream>
#include <vector>
#include <cstring>
#include <algorithm>

using namespace std;
//-------- Global Variables -----------
//! Sample data
char* pInputFileName = "input.txt";
char* pOutputFileName = "output.txt";
string strChunkFilePrefix = "chunk_";
string strOutputFilePrefix = "output_";
int RAM_SIZE = 1 << 20; // TEST: Ram=1MB, File=10M

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
    
    return 0;
}

int kWayMerge(int k, int ramSize, char *pOutputFileName)
{
    if(k == 1){
        stringstream chunkFile;
        chunkFile << strChunkFilePrefix << k << ".txt";
        rename(&chunkFile.str()[0], pOutputFileName);
        return 0;
    }

    // Canculate number of byte should be use in each chunk
    const int BUFFER_SIZE = ramSize / k;
    const int CHUNK_BATCH_LIMIT = (ramSize - BUFFER_SIZE) / k;
    cout << "BUFFER_SIZE: " << BUFFER_SIZE << endl;
    cout << "CHUNK_BATCH_LIMIT: " << CHUNK_BATCH_LIMIT << endl;

    ifstream* pInputStreamArr = new ifstream[k];
    vector<string*> *pVecArr = new vector<string*>[k];
    int* batchIndexArr = new int[k];
    for (size_t i = 0; i < k; i++)
    {
        batchIndexArr[i] = 0;
    }
    

    delete[] pInputStreamArr;
    delete[] pVecArr;
    delete[] batchIndexArr;
}

int getBatchFromChunk(int batchIndex, vector<string*>& batch, ifstream& trunkFile)
{
    return 0;
}