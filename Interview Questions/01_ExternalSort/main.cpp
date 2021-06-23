#include <iostream>
#include <cstdlib>
#include <fstream>
#include <sstream>
#include <vector>
#include <cstring>
#include <algorithm>

using namespace std;
//-------- Global Variables -----------

//main functions
int splitSortThenSave(char *inputFileName, int ramSize);
int sortThenSaveChunkFile(int index, vector<string*>& chunk);
// utility functions
bool compareStringPointers(string *s1, string *s2);



int main(int argc, char *argv[])
{
    //! Just ignore validate the input for now
    char* pInputFileName = "input.txt";
    char* pOutputFileName = "output.txt";
    int RAM_SIZE = 1 << 20; // TEST: Ram=1MB, File=10M

    if(argc > 1){
        pInputFileName = argv[1];
        pOutputFileName = argv[2];
        RAM_SIZE = atoi(argv[3]);
    }

    cout << "input(" << pInputFileName << ") output(" << pOutputFileName << ") RamSize(" << RAM_SIZE << ")" << endl;
    
    splitSortThenSave(pInputFileName, RAM_SIZE);

    const int CHUNK_SIZE = 100;
    cout << "--- FINISHED! ---" << endl;
    vector<string*> arr;
    string *s1 = new string("123");
    string *s2 = new string("3");
    string *s3 = new string("111111");
    string *s4 = new string("1111111");
    arr.push_back(s1);
    arr.push_back(s2);
    arr.push_back(s3);
    arr.push_back(s4);
    sort(arr.begin(), arr.end(), compareStringPointers);
    for (size_t i = 0; i < arr.size(); i++)
    {
        cout << *arr[i] << " " << arr[i]->size() <<endl;
    }
    

    return 0;
}


bool compareStringPointers(string *s1, string *s2)
{
    int r = (*s1).compare(*s2);
    return r < 0 ? true : false;
}

int splitSortThenSave(char *inputFileName, int maxFileSize)
{
    ifstream inputStream(inputFileName);

    if(inputStream.is_open())
    {
        int byteCount = 0;
        string strLine;
        vector<string*> vecChunks;
        int chunkCount = 0;
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
    }
    
    inputStream.close();
    return 0;
}

int sortThenSaveChunkFile(int index, vector<string*>& chunk)
{
    stringstream ss;
    ss << "temp_" << index << ".txt";
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