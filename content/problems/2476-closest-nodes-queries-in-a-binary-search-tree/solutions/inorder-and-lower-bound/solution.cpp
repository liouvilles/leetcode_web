class Solution {
    void inorder(TreeNode* node,vector<int>& sorted){
        if(!node)return;
        inorder(node->left,sorted);
        sorted.push_back(node->val);
        inorder(node->right,sorted);
    }
    public:vector<vector<int>> closestNodes(TreeNode* root,vector<int>& queries){
        vector<int> sorted;
        inorder(root,sorted);
        vector<vector<int>> answer;
        for(int query:queries){
            auto iterator=lower_bound(sorted.begin(),sorted.end(),query);
            int upper=iterator==sorted.end()?-1:*iterator;
            int lower=iterator!=sorted.end()&&*iterator==query?query:iterator==sorted.begin()?-1:*prev(iterator);
            answer.push_back({
                lower,upper
            });
        }
        return answer;
    }
};
