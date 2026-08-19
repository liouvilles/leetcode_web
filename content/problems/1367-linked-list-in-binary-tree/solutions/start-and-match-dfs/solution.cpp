class Solution {
    bool match(ListNode* head,TreeNode* node){
        if(!head)return true;
        if(!node||head->val!=node->val)return false;
        return match(head->next,node->left)||match(head->next,node->right);
    }
    public:bool isSubPath(ListNode* head,TreeNode* root){
        return root&&(match(head,root)||isSubPath(head,root->left)||isSubPath(head,root->right));
    }
};
