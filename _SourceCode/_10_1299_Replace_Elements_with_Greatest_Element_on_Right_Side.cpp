/*
The Brown Box / hoangvancong.com
Id: 1299
Name: Replace Elements with Greatest Element on Right Side
Url: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
*/
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> replaceElements(vector<int>& a) 
{
    int n = a.size();
    for (int i = n-1; i >= 0; i--)
    {
        if(i != n-1)
        {
            a[i] = max(a[i], a[i+1]);
        }
    }
    
    for (int i = 1; i < n; i++)
    {
        a[i-1] = a[i];
    }

    if(n > 0)
    {
        a[n-1] = -1;
    }
    
    return a;
}

int main()
{
    int arr[] = {17,18,5,4,6,1};
    vector<int> a (arr, arr + sizeof(arr)/sizeof(int));

    vector<int> kq = replaceElements(a);

    for (int i = 0; i < kq.size(); i++)
    {
        cout << kq[i] << " ";
    }
    

    return 0;
}