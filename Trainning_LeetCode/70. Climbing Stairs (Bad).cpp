#include <iostream>
#include <vector>
#include <queue>
#include <stack>

using namespace std;

class Solution {
public:
    int nCount = 0;
    int FINAL = 0;
    void travel(int nthStep)
    {
        // invalid step
        if(nthStep > FINAL)
            return;
        // final step
        if(nthStep == FINAL)
        {
            nCount++;
            return;
        }

        // Have to step more
        travel(nthStep + 1);
        travel(nthStep + 2);
    }

    int climbStairs(int n) {
        FINAL = n;
        travel(0);
        return nCount;
    }
};

int main()
{
    Solution s;
    s.climbStairs(2);
    return 0;
}
