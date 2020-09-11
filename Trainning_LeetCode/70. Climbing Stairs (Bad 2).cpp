#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <map>

using namespace std;

class Solution {
public:

    int travel(int n)
    {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;

        int nCount = travel(n-1) + travel(n-2);
        return nCount;
    }

    int climbStairs(int n) {
        return travel(n);
    }
};

int main()
{
    Solution s;
    s.climbStairs(2);
    return 0;
}
