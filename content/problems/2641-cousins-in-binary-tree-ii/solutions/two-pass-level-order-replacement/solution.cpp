class Solution {
    public:TreeNode* replaceValueInTree(TreeNode* root){
        root->val=0;
        vector<TreeNode*> level{
            root
        };
        while(!level.empty()){
            int nextTotal=0;
            for(auto* node:level){
                if(node->left)nextTotal+=node->left->val;
                if(node->right)nextTotal+=node->right->val;
            }
            vector<TreeNode*> nextLevel;
            for(auto* node:level){
                int siblingSum=(node->left?node->left->val:0)+(node->right?node->right->val:0);
                if(node->left){
                    node->left->val=nextTotal-siblingSum;
                    nextLevel.push_back(node->left);
                }
                if(node->right){
                    node->right->val=nextTotal-siblingSum;
                    nextLevel.push_back(node->right);
                }
            }
            level.swap(nextLevel);
        }
        return root;
    }
};
