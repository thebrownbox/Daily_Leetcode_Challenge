#include <iostream>
#include <cstdlib>
#include <fstream>
#include <vector>
#include <cstring>
#include <algorithm>

using namespace std;
//-------- Global Variables -----------


// utility functions
bool compareStringPointers(string *s1, string *s2);
/**
 * Description
 * */
int splitSortThenSave(char *inputFileName, int ramSize);


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

    cout << pInputFileName << " " << pOutputFileName << " " << RAM_SIZE << endl;
    
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

int splitSortThenSave(char *inputFileName, int ramSize)
{
    ifstream inputStream(inputFileName);

    if(inputStream.is_open())
    {
        
    }
    
    inputStream.close();
    return 0;
}
