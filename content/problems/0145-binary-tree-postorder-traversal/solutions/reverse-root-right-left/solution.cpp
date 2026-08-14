class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) { vector<int> answer; if (!root) return answer; stack<TreeNode*> nodes; nodes.push(root); while (!nodes.empty()) { TreeNode* node = nodes.top(); nodes.pop(); answer.push_back(node->val); if (node->left) nodes.push(node->left); if (node->right) nodes.push(node->right); } reverse(answer.begin(), answer.end()); return answer; }
};
