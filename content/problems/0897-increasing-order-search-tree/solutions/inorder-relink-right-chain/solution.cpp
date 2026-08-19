class Solution {
    TreeNode* tail;
    void inorder(TreeNode* node){
        if(!node)return;
        inorder(node->left);
        node->left=nullptr;
        tail->right=node;
        tail=node;
        inorder(node->right);
    }
    public:TreeNode* increasingBST(TreeNode* root){
        TreeNode dummy(0);
        tail=&dummy;
        inorder(root);
        return dummy.right;
    }
};
