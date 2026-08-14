class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) { vector<int> answer; if (!root) return answer; stack<TreeNode*> nodes; nodes.push(root); while (!nodes.empty()) { TreeNode* node = nodes.top(); nodes.pop(); answer.push_back(node->val); if (node->right) nodes.push(node->right); if (node->left) nodes.push(node->left); } return answer; }
};
