class Solution {
    vector<int> preorder;
    unordered_map<int,int> postIndex;
    TreeNode* build(int preLeft,int preRight,int postLeft){
        if(preLeft>preRight)return nullptr;
        TreeNode* root=new TreeNode(preorder[preLeft]);
        if(preLeft==preRight)return root;
        int leftSize=postIndex[preorder[preLeft+1]]-postLeft+1;
        root->left=build(preLeft+1,preLeft+leftSize,postLeft);
        root->right=build(preLeft+leftSize+1,preRight,postLeft+leftSize);
        return root;
    }
    public:TreeNode* constructFromPrePost(vector<int>& pre,vector<int>& postorder){
        preorder=pre;
        for(int i=0;i<(int)postorder.size();++i)postIndex[postorder[i]]=i;
        return build(0,preorder.size()-1,0);
    }
};
