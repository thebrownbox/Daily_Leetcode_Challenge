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
    TreeNode* insertIntoBST2(TreeNode* root, int val) {
        if(root == NULL)
            return new TreeNode(val);
        
        if(val > root->val){
            //Go right
            if(root->right == NULL){
                root->right = new TreeNode(val);
            }else{
                insertIntoBST(root->right, val);
            }
        }else{
            //Go left
            if(root->left == NULL){
                root->left = new TreeNode(val);
            }else{
                insertIntoBST(root->left, val);
            } 
        }
        return root;
    }

    TreeNode* insertIntoBST(TreeNode* root, int val) {
        TreeNode* newNode = new TreeNode(val);
        if(root == NULL)
            return newNode;
        
        TreeNode* curNode = root;
        while (curNode != NULL)
        {
            if(val > curNode->val){
                // Go right
                if(curNode->right == NULL){
                    curNode->right = newNode;
                    break;
                }else{
                    curNode = curNode->right;
                }
            }else{ // Go left
                if(curNode->left == NULL){
                    curNode->left = newNode;
                    break;
                }else{
                    curNode = curNode->left;
                }
            }
        }

        return root;
    }
};


int main()
{


    return 0;
}