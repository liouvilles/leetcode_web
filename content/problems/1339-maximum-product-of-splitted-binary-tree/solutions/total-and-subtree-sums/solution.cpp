class Solution {
    long long total=0,maximum=0;
    long long sum(TreeNode* node){
        return node?node->val+sum(node->left)+sum(node->right):0;
    }
    long long sumAndProduct(TreeNode* node){
        if(!node)return 0;
        long long sub=node->val+sumAndProduct(node->left)+sumAndProduct(node->right);
        maximum=max(maximum,sub*(total-sub));
        return sub;
    }
    public:int maxProduct(TreeNode* root){
        total=sum(root);
        sumAndProduct(root);
        return maximum%1000000007;
    }
};
