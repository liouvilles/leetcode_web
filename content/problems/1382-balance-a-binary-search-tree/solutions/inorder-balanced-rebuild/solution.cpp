class Solution {
    vector<int> values;
    void inorder(TreeNode* node){
        if(!node)return;
        inorder(node->left);
        values.push_back(node->val);
        inorder(node->right);
    }
    TreeNode* build(int left,int right){
        if(left>right)return nullptr;
        int middle=left+(right-left)/2;
        TreeNode* root=new TreeNode(values[middle]);
        root->left=build(left,middle-1);
        root->right=build(middle+1,right);
        return root;
    }
    public:TreeNode* balanceBST(TreeNode* root){
        inorder(root);
        return build(0,values.size()-1);
    }
};
