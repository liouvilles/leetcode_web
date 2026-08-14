class Solution {
    void dfs(TreeNode* node, long long remaining, vector<int>& path, vector<vector<int>>& answer) { if (!node) return; path.push_back(node->val); if (!node->left && !node->right && remaining == node->val) answer.push_back(path); else { dfs(node->left, remaining - node->val, path, answer); dfs(node->right, remaining - node->val, path, answer); } path.pop_back(); }
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) { vector<vector<int>> answer; vector<int> path; dfs(root, targetSum, path, answer); return answer; }
};
