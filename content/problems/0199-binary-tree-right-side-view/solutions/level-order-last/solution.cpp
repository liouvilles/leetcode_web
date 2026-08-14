class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        if (!root) return {};
        vector<int> answer; queue<TreeNode*> pending; pending.push(root);
        while (!pending.empty()) { int size = pending.size(); for (int index = 0; index < size; ++index) { TreeNode* node = pending.front(); pending.pop(); if (index == size - 1) answer.push_back(node->val); if (node->left) pending.push(node->left); if (node->right) pending.push(node->right); } }
        return answer;
    }
};
