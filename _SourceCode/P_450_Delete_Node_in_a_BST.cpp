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

    TreeNode* findLeftMostNode(TreeNode* curNode){
        if(curNode == NULL)
            return NULL;
        if(curNode->left == NULL)
            return curNode;
        return findLeftMostNode(curNode->left);
    }

    void deleteNode(TreeNode* curNode, TreeNode *delNode){
        if(curNode == NULL)
            return;
        if(curNode->left == delNode){
            delete delNode;
            curNode->left = NULL;
        }else if(curNode->right == delNode){
            delete delNode;
            curNode->right = NULL;
        }else if(delNode->val > curNode->val){
            deleteNode(curNode->right, delNode);
        }else if(delNode->val < curNode->val){
            deleteNode(curNode->left, delNode);
        }
    }

    TreeNode* deleteNode(TreeNode* root, int key) {
        if(root == NULL)
            return NULL;
        
        TreeNode* curNode = root;
        TreeNode* parrentNode = NULL;
        bool isRightNode = true;
        while (curNode != NULL)
        {
            if(curNode->val == key){ // curNode is node need to delete
                if(curNode->left == NULL && curNode->right == NULL)
                {
                    // 1. Khong co con
                    if(parrentNode == NULL){
                        // curNode is root
                        return NULL;
                    }else{
                        delete curNode;
                        if(isRightNode)
                            parrentNode->right = NULL;
                        else 
                            parrentNode->left = NULL;
                        return root;
                    }
                }else if(curNode->left != NULL && curNode->right != NULL){
                    // 2. Co 2 con
                    TreeNode* leftMostNode = findLeftMostNode(curNode->right);
                    if(leftMostNode == NULL){
                        printf("=== NOT FOUND leftMostNode ===");
                    }else{
                        int temp = leftMostNode->val;
                        deleteNode(curNode, temp);
                        curNode->val = temp;
                        return root;
                    }
                }else{
                    // 3. Chi co node trai / phai
                    TreeNode* childNode = curNode->left != NULL ? curNode->left : curNode->right;
                    if(parrentNode == NULL){
                        //curNode is root
                        delete curNode;
                        root = childNode;
                        return root;
                    }else{
                        delete curNode;
                        if(isRightNode)
                            parrentNode->right = childNode;
                        else parrentNode->left = childNode;
                        return root;
                    }
                }

                break;
            }else if(key > curNode->val){
                parrentNode = curNode;
                curNode = curNode->right;
                isRightNode = true;
            }else{
                parrentNode = curNode;
                curNode = curNode->left;
                isRightNode = false;             
            }
        }
        return root;
    }

};


int main()
{


    return 0;
}