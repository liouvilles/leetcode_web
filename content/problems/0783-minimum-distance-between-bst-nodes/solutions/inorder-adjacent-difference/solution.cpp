class Solution {
    int previous=-1,answer=INT_MAX;
    void inorder(TreeNode* node){
        if(!node)return;
        inorder(node->left);
        if(previous!=-1)answer=min(answer,node->val-previous);
        previous=node->val;
        inorder(node->right);
    }
    public:int minDiffInBST(TreeNode* root){
        inorder(root);
        return answer;
    }
};
