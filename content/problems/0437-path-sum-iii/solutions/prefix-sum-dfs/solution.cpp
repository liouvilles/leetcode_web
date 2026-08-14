class Solution {
    int visit(TreeNode* node, long long prefix, long long target, unordered_map<long long, int>& counts) {
        if (!node) return 0;
        long long current = prefix + node->val; int answer = counts[current - target]; ++counts[current];
        answer += visit(node->left, current, target, counts) + visit(node->right, current, target, counts);
        --counts[current]; return answer;
    }
public:
    int pathSum(TreeNode* root, int targetSum) { unordered_map<long long, int> counts{{0, 1}}; return visit(root, 0, targetSum, counts); }
};
