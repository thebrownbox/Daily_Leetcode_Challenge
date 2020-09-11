#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <map>

using namespace std;

class Solution {
public:
    map<int, int> mCount;

    int travel(int n)
    {
        if(mCount.count(n) > 0)
        {
            return mCount[n];
        }

        int nCount = travel(n-1) + travel(n-2);
        mCount[n] = nCount;
        return nCount;
    }

    int climbStairs(int n) {
        mCount[0] = 0;
        mCount[1] = 1;
        mCount[2] = 2;
        travel(n);
        return mCount[n];
    }
};

int main()
{
    Solution s;
    s.climbStairs(2);
    return 0;
}
