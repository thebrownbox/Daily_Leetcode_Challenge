/*
The Brown Box
Id: 27
Name: Remove Element
Url: https://leetcode.com/problems/remove-element/
*/

#include <iostream>
#include <vector>

using namespace std;

int removeElement(vector<int>& a, int val) 
{
    int n = a.size();
    int curIndex = 0;

    for (int i = 0; i < n; i++)
    {
        if(a[i] != val)
        {
            a[curIndex] = a[i];
            curIndex++;
        }
    }
    
    return curIndex;
}

int main()
{
    int arr[] = {0,1,2,2,3,0,4,2};
    int val = 2;
    vector<int> a(arr, arr + sizeof(arr)/sizeof(int));

    int n = removeElement(a, val);
    for (int i = 0; i < n; i++)
    {
        cout << a[i] << " ";
    }
    

    return 0;
}