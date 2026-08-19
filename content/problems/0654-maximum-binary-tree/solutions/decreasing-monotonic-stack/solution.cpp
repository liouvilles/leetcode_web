class Solution {
    public: TreeNode* constructMaximumBinaryTree(vector<int>& nums){
        vector<TreeNode*> stack;
        for(int value:nums){
            TreeNode* node=new TreeNode(value);
            while(!stack.empty()&&stack.back()->val<value){
                node->left=stack.back();
                stack.pop_back();
            }
            if(!stack.empty())stack.back()->right=node;
            stack.push_back(node);
        }
        return stack.front();
    }
};
