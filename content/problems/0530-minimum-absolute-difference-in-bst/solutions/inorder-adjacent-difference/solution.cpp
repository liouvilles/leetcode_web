class Solution {
    optional<int> previous;
    int best=INT_MAX;
    void inorder(TreeNode* node){
        if(!node)return;
        inorder(node->left);
        if(previous)best=min(best,node->val-*previous);
        previous=node->val;
        inorder(node->right);
    }
    public:int getMinimumDifference(TreeNode* root){
        inorder(root);
        return best;
    }
};
