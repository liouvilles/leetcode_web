class Solution {
    int postIndex; unordered_map<int, int> positions;
    TreeNode* build(int left, int right, vector<int>& postorder) { if (left > right) return nullptr; int value = postorder[postIndex--], middle = positions[value]; TreeNode* root = new TreeNode(value); root->right = build(middle + 1, right, postorder); root->left = build(left, middle - 1, postorder); return root; }
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) { for (int index = 0; index < (int)inorder.size(); ++index) positions[inorder[index]] = index; postIndex = postorder.size() - 1; return build(0, inorder.size() - 1, postorder); }
};
