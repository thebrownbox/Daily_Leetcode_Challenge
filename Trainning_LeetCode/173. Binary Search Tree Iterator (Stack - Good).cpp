#include <iostream>
#include <vector>
#include <queue>
#include <stack>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class BSTIterator {
public:
    stack<TreeNode*> mStack;

    BSTIterator(TreeNode* root) {
        travelToMostLeft(root);
    }

    void travelToMostLeft(TreeNode* curNode){
        if(curNode != NULL){
            mStack.push(curNode);
            if(curNode->left != NULL){
                travelToMostLeft(curNode->left);
            }
        }
    }


    /** @return the next smallest number */
    int next() {
        TreeNode* curMostLeft = mStack.top();
        mStack.pop();

        if(curMostLeft->right != NULL){
            travelToMostLeft(curMostLeft->right);
        }

        return curMostLeft->val;
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {
        return !mStack.empty();
    }
};

int main()
{
    cout << "Hello World!" << endl;
    return 0;
}
