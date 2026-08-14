class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<TreeNode*> nodes;
        TreeNode* current = root;
        while (current || !nodes.empty()) {
            while (current) {
                nodes.push(current);
                current = current->left;
            }
            current = nodes.top(); nodes.pop();
            result.push_back(current->val);
            current = current->right;
        }
        return result;
    }
};
