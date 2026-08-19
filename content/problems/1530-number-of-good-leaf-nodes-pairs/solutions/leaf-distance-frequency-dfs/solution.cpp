class Solution {
    int distance,answer=0;
    vector<int> dfs(TreeNode* node){
        vector<int> count(distance+1);
        if(!node)return count;
        if(!node->left&&!node->right){
            count[0]=1;
            return count;
        }
        auto left=dfs(node->left),right=dfs(node->right);
        for(int i=0;i<=distance;++i)for(int j=0;j<=distance;++j)if(i+j+2<=distance)answer+=left[i]*right[j];
        for(int d=0;d<distance;++d)count[d+1]=left[d]+right[d];
        return count;
    }
    public:int countPairs(TreeNode* root,int distance){
        this->distance=distance;
        dfs(root);
        return answer;
    }
};
