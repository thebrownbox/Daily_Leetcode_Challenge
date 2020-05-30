/*
The Brown Box / hoangvancong.com
Id: 1346
Name: Check If N and Its Double Exist
Url: https://leetcode.com/problems/check-if-n-and-its-double-exist/
*/
#include <iostream>
#include <vector>

using namespace std;

bool checkIfExist(vector<int>& a) 
{
    int n = a.size();
    for (int i = 0; i < n; i++)
    {
        for (int j = i+1; j < n; j++)
        {
            if(a[i] == 2*a[j] || a[j] == 2*a[i])
            {
                return true;
            }
        }
        
    }
    
    return false;
}

int main()
{


    return 0;
}