#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int countNumOfDigits2(int n)
{
    return (int)log10(n) + 1;
}

int countNumOfDigits(int n)
{
    int count = 0;

    // n = 10
    while(n != 0)
    {
        n = n/10;
        count++;
    }

    return count;
}

int findNumbers(vector<int>& a) {
    int count = 0;

    for (int i = 0; i < a.size(); i++)
    {
        if(countNumOfDigits2(a[i]) % 2 == 0)
        {
            count++;
        }
    }
    
    return count;
}

int main()
{
    int arr[] = {12, 345, 2, 6, 7896};
    vector<int> a(arr, arr + sizeof(arr) / sizeof(int));

    cout << findNumbers(a) << endl;

    return 0;
}