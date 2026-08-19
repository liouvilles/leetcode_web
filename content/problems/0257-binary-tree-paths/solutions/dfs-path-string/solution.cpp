class Solution {
    void dfs(TreeNode* node,string path,vector<string>& answer){
        if(!node)return;
        string current=path.empty()?to_string(node->val):path+"->"+to_string(node->val);
        if(!node->left&&!node->right)answer.push_back(current);
        else{
            dfs(node->left,current,answer);
            dfs(node->right,current,answer);
        }
    }
    public:vector<string> binaryTreePaths(TreeNode* root){
        vector<string> answer;
        dfs(root,"",answer);
        return answer;
    }
};
