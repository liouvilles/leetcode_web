class Solution {
    int leftSize=0,rightSize=0,target=0;
    int size(TreeNode* node){
        if(!node)return 0;
        int left=size(node->left),right=size(node->right);
        if(node->val==target){
            leftSize=left;
            rightSize=right;
        }
        return left+right+1;
    }
    public:bool btreeGameWinningMove(TreeNode* root,int n,int x){
        target=x;
        size(root);
        int parent=n-1-leftSize-rightSize;
        return max({
            parent,leftSize,rightSize
        })>n/2;
    }
};
