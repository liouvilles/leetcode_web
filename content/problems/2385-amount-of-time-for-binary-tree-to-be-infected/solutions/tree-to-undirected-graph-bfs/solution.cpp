class Solution {
    unordered_map<int,vector<int>> graph;
    void build(TreeNode* node){
        if(!node)return;
        if(node->left){
            graph[node->val].push_back(node->left->val);
            graph[node->left->val].push_back(node->val);
            build(node->left);
        }
        if(node->right){
            graph[node->val].push_back(node->right->val);
            graph[node->right->val].push_back(node->val);
            build(node->right);
        }
    }
    public:int amountOfTime(TreeNode* root,int start){
        build(root);
        queue<int> pending;
        unordered_set<int> seen;
        pending.push(start);
        seen.insert(start);
        int minutes=-1;
        while(!pending.empty()){
            ++minutes;
            for(int size=pending.size();size--;) {
                int node=pending.front();
                pending.pop();
                for(int next:graph[node])if(seen.insert(next).second)pending.push(next);
            }
        }
        return minutes;
    }
};
