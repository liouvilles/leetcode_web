class Solution {
    public: vector<double> averageOfLevels(TreeNode* root){
        vector<double> answer;
        queue<TreeNode*> nodes;
        nodes.push(root);
        while(!nodes.empty()){
            int size=nodes.size();
            long long sum=0;
            for(int i=0;i<size;++i){
                TreeNode* node=nodes.front();
                nodes.pop();
                sum+=node->val;
                if(node->left)nodes.push(node->left);
                if(node->right)nodes.push(node->right);
            }
            answer.push_back((double)sum/size);
        }
        return answer;
    }
};
