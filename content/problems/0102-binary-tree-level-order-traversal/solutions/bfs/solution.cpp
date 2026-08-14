class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if (!root) return {};
        vector<vector<int>> result;
        queue<TreeNode*> nodes;
        nodes.push(root);
        while (!nodes.empty()) {
            int size = nodes.size();
            vector<int> level;
            while (size--) {
                TreeNode* node = nodes.front(); nodes.pop();
                level.push_back(node->val);
                if (node->left) nodes.push(node->left);
                if (node->right) nodes.push(node->right);
            }
            result.push_back(move(level));
        }
        return result;
    }
};
