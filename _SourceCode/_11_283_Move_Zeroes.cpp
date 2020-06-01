/*
The Brown Box / hoangvancong.com
Id: 283
Name: Move Zeroes
Url: https://leetcode.com/problems/move-zeroes/
*/
#include <iostream>
#include <vector>

using namespace std;

void moveZeroes(vector<int>& a) 
{
    int n = a.size();
    int curIndex = 0;
    for (int i = 0; i < n; i++)
    {
        if(a[i] != 0)
        {
            a[curIndex] = a[i];
            curIndex++;
        }
    }

    for (; curIndex < n; curIndex++)
    {
        a[curIndex] = 0;
    }
}

int main()
{
    int arr[] = {0,1,0,3,12 };
    vector<int> a(arr, arr+sizeof(arr)/sizeof(int));

    moveZeroes(a);

    for (int i = 0; i < a.size(); i++)
    {
        cout << a[i] << " ";
    }
    

    return 0;
}