class Solution {
    int preorderIndex = 0;
    vector<int>* preorderValues = nullptr;
    unordered_map<int, int> inorderIndex;

    TreeNode* build(int left, int right) {
        if (left > right) return nullptr;
        int value = (*preorderValues)[preorderIndex++];
        TreeNode* root = new TreeNode(value);
        int middle = inorderIndex[value];
        root->left = build(left, middle - 1);
        root->right = build(middle + 1, right);
        return root;
    }
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        preorderValues = &preorder;
        preorderIndex = 0;
        inorderIndex.clear();
        for (int index = 0; index < (int)inorder.size(); ++index) inorderIndex[inorder[index]] = index;
        return build(0, (int)inorder.size() - 1);
    }
};
