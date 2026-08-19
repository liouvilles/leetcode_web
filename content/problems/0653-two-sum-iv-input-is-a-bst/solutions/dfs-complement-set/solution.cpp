class Solution {
    bool dfs(TreeNode* node,int target,unordered_set<int>& seen){
        if(!node)return false;
        if(seen.count(target-node->val))return true;
        seen.insert(node->val);
        return dfs(node->left,target,seen)||dfs(node->right,target,seen);
    }
    public:bool findTarget(TreeNode* root,int k){
        unordered_set<int> seen;
        return dfs(root,k,seen);
    }
};
