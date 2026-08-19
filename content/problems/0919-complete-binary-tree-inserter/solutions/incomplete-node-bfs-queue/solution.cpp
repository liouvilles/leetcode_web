class CBTInserter {
    TreeNode* root;
    queue<TreeNode*> candidates;
    public:CBTInserter(TreeNode* root):root(root){
        queue<TreeNode*> pending;
        pending.push(root);
        while(!pending.empty()){
            TreeNode* node=pending.front();
            pending.pop();
            if(!node->left||!node->right)candidates.push(node);
            if(node->left)pending.push(node->left);
            if(node->right)pending.push(node->right);
        }
    }
    int insert(int value){
        TreeNode* parent=candidates.front();
        TreeNode* node=new TreeNode(value);
        if(!parent->left)parent->left=node;
        else{
            parent->right=node;
            candidates.pop();
        }
        candidates.push(node);
        return parent->val;
    }
    TreeNode* get_root(){
        return root;
    }
};
