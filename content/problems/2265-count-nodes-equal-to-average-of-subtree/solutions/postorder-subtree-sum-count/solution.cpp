class Solution {
    int answer=0;
    pair<int,int> dfs(TreeNode* node){
        if(!node)return{
            0,0
        };
        auto left=dfs(node->left),right=dfs(node->right);
        int sum=node->val+left.first+right.first,count=1+left.second+right.second;
        if(node->val==sum/count)++answer;
        return{
            sum,count
        };
    }
    public:int averageOfSubtree(TreeNode* root){
        dfs(root);
        return answer;
    }
};
