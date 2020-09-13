#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <map>

using namespace std;

//Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    vector<int> result;
    int FINAL;

    vector<int> getRow(int rowIndex) {
        FINAL = rowIndex;

        result.resize(FINAL + 1, 0);
        result[0] = 1;
    
        for (int k = 1; k <= FINAL; k++)
        {
            for (int i = k; i >= 1; i--)
                result[i] = result[i-1] + result[i];
        }
        

        return result;
    }
};

int main()
{
    Solution s;
    vector<int> v = s.getRow(20);
    for (int i = 0; i < v.size(); i++)
    {
        cout << v[i] << " ";
    }
    
    return 0;
}
