class Solution {
    public: bool isCompleteTree(TreeNode* root){
        if(!root)return true;
        queue<TreeNode*> pending;
        pending.push(root);
        bool gap=false;
        while(!pending.empty()){
            TreeNode* node=pending.front();
            pending.pop();
            if(node->left){
                if(gap)return false;
                pending.push(node->left);
            }else gap=true;
            if(node->right){
                if(gap)return false;
                pending.push(node->right);
            }else gap=true;
        }
        return true;
    }
};
