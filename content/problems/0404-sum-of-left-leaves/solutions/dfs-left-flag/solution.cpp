class Solution {
    int dfs(TreeNode* node,bool left){
        if(!node)return 0;
        if(!node->left&&!node->right)return left?node->val:0;
        return dfs(node->left,true)+dfs(node->right,false);
    }
    public:int sumOfLeftLeaves(TreeNode* root){
        return dfs(root,false);
    }
};
