class Solution {
    public: vector<int> largestValues(TreeNode* root){
        if(!root)return{
        };
        vector<int> answer;
        queue<TreeNode*> nodes;
        nodes.push(root);
        while(!nodes.empty()){
            int maximum=INT_MIN;
            for(int size=nodes.size();size>0;--size){
                TreeNode* node=nodes.front();
                nodes.pop();
                maximum=max(maximum,node->val);
                if(node->left)nodes.push(node->left);
                if(node->right)nodes.push(node->right);
            }
            answer.push_back(maximum);
        }
        return answer;
    }
};
