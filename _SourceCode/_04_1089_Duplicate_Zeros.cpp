#include <iostream>
#include <vector>

using namespace std;

void duplicateZeros(vector<int>& a) 
{
    int n = a.size();

    for (int i = 0; i < n; i++)
    {
        if(a[i] == 0)
        {
            // Dich a[i+1] - a[n-2] sang phai 1 don vi
            for (int j = n-2; j >= i+1; j--)
            {
                a[j+1] = a[j];
            }

            if(i+1 < n)
            {
                // Gan a[i+1] = 0
                a[i+1] = 0;
                i++;
            }
        }
    }
}

int main()
{
    int arr[] = {1,2,3};
    vector<int> a(arr, arr + sizeof(arr)/sizeof(int));

    duplicateZeros(a);

    for (int i = 0; i < a.size(); i++)
    {
        cout << a[i] << " ";
    }
    

    return 0;
}