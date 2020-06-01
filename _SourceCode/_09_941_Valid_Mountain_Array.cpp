/*
The Brown Box / hoangvancong.com
Id: 941
Name: Valid Mountain Array
Url: https://leetcode.com/problems/valid-mountain-array/
*/
#include <iostream>
#include <vector>

using namespace std;

bool validMountainArray(vector<int>& a) 
{
    int n = a.size();
    bool bIsIncreasing = true;

    if(n < 3)
    {
        return false;
    }

    for (int i = 0; (i+1) < n; i++)
    {
        int j = i+1; // Phan tu phia sau
        if(a[i] > a[j]) // Day giam
        {
            if(bIsIncreasing == false)
            {
                // normal
            }
            else // bIsIncreasing = true
            {
                if(i == 0)
                {
                    return false;
                }
                bIsIncreasing = false;
            }
        }
        else if(a[i] < a[j]) // Day Tang
        {
            if(bIsIncreasing == true)
            {
                // normal
            }
            else// bIsIncreasing = false: Day dang xet la day giam
            {
                return false;
            }
        }
        else // a[i] == a[j]
        {
            return false;
        }
    }

    if(bIsIncreasing == false) // Day dang xet cuoi cung la day giam
        return true;
    
    return false;
}

int main()
{


    return 0;
}