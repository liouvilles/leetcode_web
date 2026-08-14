class Solution {
    int answer = INT_MIN;
    int gain(TreeNode* node) { if (!node) return 0; int left = max(0, gain(node->left)), right = max(0, gain(node->right)); answer = max(answer, node->val + left + right); return node->val + max(left, right); }
public:
    int maxPathSum(TreeNode* root) { answer = INT_MIN; gain(root); return answer; }
};
