#include <iostream>
#include <vector>
#include <queue>

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
    TreeNode* root;
    queue<TreeNode*> mQueue;

    BSTIterator(TreeNode* root) {
        this->root = root;
        travelLNR(root);
    }

    void printQueue(){
        while (mQueue.empty() == false) {
            TreeNode* c = mQueue.front();
            cout << c->val << " ";
            mQueue.pop();
        }
    }

    // Travel Left-Node-Right
    void travelLNR(TreeNode* curNode){
        if(curNode != NULL)
        {
            if(curNode->left != NULL){
                travelLNR(curNode->left);
            }
            //Duyet Node hien tai
            mQueue.push(curNode);
            if(curNode->right != NULL){
                travelLNR(curNode->right);
            }
        }
    }

    /** @return the next smallest number */
    int next() {
        TreeNode* c = mQueue.front();
//        cout << c->val << " ";
        mQueue.pop();
        return c->val;
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {
        return !mQueue.empty();
    }
};

int main()
{
    cout << "Hello World!" << endl;
    return 0;
}
