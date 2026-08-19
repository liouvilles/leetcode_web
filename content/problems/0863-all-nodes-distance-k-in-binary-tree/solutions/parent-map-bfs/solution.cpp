class Solution {
    unordered_map<TreeNode*,TreeNode*> parent;
    TreeNode* actualTarget=nullptr;
    void build(TreeNode* node,TreeNode* p,int targetValue){
        if(!node)return;
        parent[node]=p;
        if(node->val==targetValue)actualTarget=node;
        build(node->left,node,targetValue);
        build(node->right,node,targetValue);
    }
    void add(TreeNode* node,unordered_set<TreeNode*>& seen,queue<TreeNode*>& pending){
        if(node&&seen.insert(node).second)pending.push(node);
    }
    public:vector<int> distanceK(TreeNode* root,TreeNode* target,int k){
        build(root,nullptr,target->val);
        queue<TreeNode*> pending;
        unordered_set<TreeNode*> seen{
            actualTarget
        };
        pending.push(actualTarget);
        while(k--)for(int size=pending.size();size;--size){
            TreeNode* node=pending.front();
            pending.pop();
            add(node->left,seen,pending);
            add(node->right,seen,pending);
            add(parent[node],seen,pending);
        }
        vector<int> answer;
        while(!pending.empty()){
            answer.push_back(pending.front()->val);
            pending.pop();
        }
        return answer;
    }
};
