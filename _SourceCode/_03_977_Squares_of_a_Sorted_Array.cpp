#include <iostream>
#include <vector>

using namespace std;

vector<int> sortedSquares(vector<int>& a) 
{
    vector<int> v(a.size(), 0);
    int n = a.size();

    // Tim i va j
    // Tim i: La so am cuoi cung trong day
    int i = -1;
    while((i+1) < n && a[i+1] < 0)
    {
        i++;
    }

    // Tim j: La gia tri khong am trai cung trong day
    int j = n;
    while((j-1) >= 0 && a[j-1] >= 0)
    {
        j--;
    }

    int k = 0; // index of v
    //cout << " i = " << i << " j = " << j << endl;
    while(i >= 0 || j < n)
    {
        if(i>=0 && j<n) // both j and i are valid
        {
            int ii = a[i] * a[i];
            int jj = a[j] * a[j];

            if(ii <= jj)
            {
                v[k] = ii;
                i--; k++;    
            }
            else
            {
                v[k] = jj;
                j++; k++;   
            }
        }
        else if(i >= 0){ // only i valid
            v[k] = a[i] * a[i];
            i--; k++;
        }else{  // only j valid
            v[k] = a[j] * a[j];
            j++; k++;
        }
    }

    return v;
}

int main()
{
    int arr[] = { -4,-1,0,3,10 };
    vector<int> a(arr, arr + sizeof(arr)/sizeof(int));

    vector<int> v = sortedSquares(a);

    for (int i = 0; i < v.size(); i++)
    {
        cout << v[i] << " ";
    }
    

    return 0;
}