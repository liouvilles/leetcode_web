class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        if (!root) return {}; vector<vector<int>> answer; queue<TreeNode*> nodes; nodes.push(root); bool leftToRight = true;
        while (!nodes.empty()) { int size = nodes.size(); vector<int> level(size); for (int index = 0; index < size; ++index) { TreeNode* node = nodes.front(); nodes.pop(); level[leftToRight ? index : size - 1 - index] = node->val; if (node->left) nodes.push(node->left); if (node->right) nodes.push(node->right); } answer.push_back(level); leftToRight = !leftToRight; } return answer;
    }
};
