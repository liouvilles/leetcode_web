class Solution {
    unordered_map<int,vector<TreeNode*>> memo;
    public:vector<TreeNode*> allPossibleFBT(int n){
        if(n%2==0)return{
        };
        if(n==1)return{
            new TreeNode(0)
        };
        if(memo.count(n))return memo[n];
        vector<TreeNode*> answer;
        for(int leftCount=1;leftCount<n;leftCount+=2)for(TreeNode* left:allPossibleFBT(leftCount))for(TreeNode* right:allPossibleFBT(n-1-leftCount)){
            TreeNode* root=new TreeNode(0);
            root->left=left;
            root->right=right;
            answer.push_back(root);
        }
        return memo[n]=answer;
    }
};
