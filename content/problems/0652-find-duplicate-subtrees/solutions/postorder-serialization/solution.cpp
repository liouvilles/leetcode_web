class Solution {
    unordered_map<string,int> counts;
    vector<TreeNode*> answer;
    string serialize(TreeNode* node){
        if(!node)return"#";
        string key=to_string(node->val)+","+serialize(node->left)+","+serialize(node->right);
        if(++counts[key]==2)answer.push_back(node);
        return key;
    }
    public:vector<TreeNode*> findDuplicateSubtrees(TreeNode* root){
        serialize(root);
        return answer;
    }
};
