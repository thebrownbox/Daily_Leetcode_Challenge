#include <iostream>


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
    TreeNode* searchBST2(TreeNode* root, int val) {
        if(root == NULL)
            return NULL;

        if(root->val == val)
            return root;

        if(val > root->val)
            return searchBST(root->right);

        return searchBST(root->left);
    }

    TreeNode* searchBST(TreeNode* root, int val) {
        if(root == NULL)
            return NULL;

        TreeNode* curNode = root;
        while(curNode != NULL)
        {
            if(curNode->val == val)
                return curNode;
            if(val > curNode->val)
                curNode = curNode->right;
            else curNode = curNode->left;
        }
        return curNode;
    }
};


int main()
{


    return 0;
}