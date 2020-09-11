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
    int maxDepth(TreeNode* root) {
        if(root == NULL)
            return 0;
        int depLeft = maxDepth(root->left);
        int depRight = maxDepth(root->right);
        return 1 + max(depLeft, depRight);
    }
};

int main()
{
    Solution s;
    s.climbStairs(2);
    return 0;
}
