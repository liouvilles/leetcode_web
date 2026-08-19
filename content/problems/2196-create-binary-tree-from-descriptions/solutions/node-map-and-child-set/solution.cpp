class Solution {
    public:TreeNode* createBinaryTree(vector<vector<int>>& descriptions){
        unordered_map<int,TreeNode*> nodes;
        unordered_set<int> children;
        for(auto& description:descriptions){
            if(!nodes.count(description[0]))nodes[description[0]]=new TreeNode(description[0]);
            if(!nodes.count(description[1]))nodes[description[1]]=new TreeNode(description[1]);
            if(description[2])nodes[description[0]]->left=nodes[description[1]];
            else nodes[description[0]]->right=nodes[description[1]];
            children.insert(description[1]);
        }
        for(auto [value,node]:nodes)if(!children.count(value))return node;
        return nullptr;
    }
};
