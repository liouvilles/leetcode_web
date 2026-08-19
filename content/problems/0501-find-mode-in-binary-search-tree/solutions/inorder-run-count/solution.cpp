class Solution {
    optional<int> previous;
    int count=0,best=0;
    vector<int> modes;
    void inorder(TreeNode* node){
        if(!node)return;
        inorder(node->left);
        count=previous&&*previous==node->val?count+1:1;
        if(count>best){
            best=count;
            modes.clear();
            modes.push_back(node->val);
        }else if(count==best)modes.push_back(node->val);
        previous=node->val;
        inorder(node->right);
    }
    public:vector<int> findMode(TreeNode* root){
        inorder(root);
        return modes;
    }
};
