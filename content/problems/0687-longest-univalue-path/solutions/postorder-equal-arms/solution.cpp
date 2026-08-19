class Solution {
    int best=0;
    int dfs(TreeNode* node){
        if(!node)return 0;
        int left=dfs(node->left),right=dfs(node->right);
        int leftArm=node->left&&node->left->val==node->val?left+1:0;
        int rightArm=node->right&&node->right->val==node->val?right+1:0;
        best=max(best,leftArm+rightArm);
        return max(leftArm,rightArm);
    }
    public:int longestUnivaluePath(TreeNode* root){
        dfs(root);
        return best;
    }
};
