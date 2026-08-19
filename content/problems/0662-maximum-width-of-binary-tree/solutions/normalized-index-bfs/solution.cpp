class Solution {
    public: int widthOfBinaryTree(TreeNode* root){
        queue<pair<TreeNode*,unsigned long long>> nodes;
        nodes.push({
            root,0
        });
        unsigned long long best=0;
        while(!nodes.empty()){
            int size=nodes.size();
            auto base=nodes.front().second,first=0ULL,last=0ULL;
            for(int i=0;i<size;++i){
                auto [node,raw]=nodes.front();
                nodes.pop();
                auto index=raw-base;
                if(i==0)first=index;
                if(i==size-1)last=index;
                if(node->left)nodes.push({
                    node->left,index*2
                });
                if(node->right)nodes.push({
                    node->right,index*2+1
                });
            }
            best=max(best,last-first+1);
        }
        return best;
    }
};
