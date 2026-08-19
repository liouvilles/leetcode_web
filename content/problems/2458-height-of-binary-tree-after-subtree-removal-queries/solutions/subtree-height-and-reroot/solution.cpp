class Solution {
    unordered_map<int,int> height,answer;
    int measure(TreeNode* node){
        if(!node)return 0;
        int value=1+max(measure(node->left),measure(node->right));
        return height[node->val]=value;
    }
    void reroot(TreeNode* node,int depth,int rest){
        if(!node)return;
        answer[node->val]=rest;
        reroot(node->left,depth+1,max(rest,depth+(node->right?height[node->right->val]:0)));
        reroot(node->right,depth+1,max(rest,depth+(node->left?height[node->left->val]:0)));
    }
    public:vector<int> treeQueries(TreeNode* root,vector<int>& queries){
        measure(root);
        reroot(root,0,0);
        vector<int> result;
        for(int query:queries)result.push_back(answer[query]);
        return result;
    }
};
