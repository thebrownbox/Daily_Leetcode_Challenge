/*
The Brown Box / hoangvancong.com
Id: 905. 
Name: Sort Array By Parity
Url: https://leetcode.com/problems/sort-array-by-parity/
*/
#include <iostream>
#include <vector>

using namespace std;

void _swap(int &a, int &b)
{
    int t = a;
    a = b;
    b = t;
}

vector<int> sortArrayByParity(vector<int>& a) 
{
    int n = a.size();
    int i = 0;
    int j = n - 1;

    while(i < j)
    {
        if(a[i]%2 != 0)// a[i] la so le
        {
            // Xu ly
            if(a[j]%2 == 0)// a[j] la So chan
            {
                if(i < j)
                {
                    _swap(a[i], a[j]);
                }
            }
            else// So le
            {
                j--;
            }
        }
        else// a[i] la so chan
        {
            i++;
        }
    }

    return a;
}

int main()
{
    int arr[] = {1,1,1,2,1,1,1,2,1,1,2};
    vector<int> a(arr, arr+sizeof(arr)/sizeof(int));

    sortArrayByParity(a);

    for (int i = 0; i < a.size(); i++)
    {
        cout << a[i] << " ";
    }
    

    return 0;
}