class Solution {
    void append(TreeNode* node,string& answer){
        if(!node)return;
        answer+=to_string(node->val);
        if(node->left||node->right){
            answer+='(';
            append(node->left,answer);
            answer+=')';
        }
        if(node->right){
            answer+='(';
            append(node->right,answer);
            answer+=')';
        }
    }
    public:string tree2str(TreeNode* root){
        string answer;
        append(root,answer);
        return answer;
    }
};
