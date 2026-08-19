class Solution {
    int moves=0;
    int balance(TreeNode* node){
        if(!node)return 0;
        int left=balance(node->left),right=balance(node->right);
        moves+=abs(left)+abs(right);
        return node->val+left+right-1;
    }
    public:int distributeCoins(TreeNode* root){
        moves=0;
        balance(root);
        return moves;
    }
};
