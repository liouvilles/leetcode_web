class Solution {
    bool find(TreeNode* node,int target,string& path){
        if(!node)return false;
        if(node->val==target)return true;
        path+='L';
        if(find(node->left,target,path))return true;
        path.pop_back();
        path+='R';
        if(find(node->right,target,path))return true;
        path.pop_back();
        return false;
    }
    public: string getDirections(TreeNode* root,int startValue,int destValue){
        string start,destination;
        find(root,startValue,start);
        find(root,destValue,destination);
        int common=0;
        while(common<(int)start.size()&&common<(int)destination.size()&&start[common]==destination[common])++common;
        return string(start.size()-common,'U')+destination.substr(common);
    }
};
