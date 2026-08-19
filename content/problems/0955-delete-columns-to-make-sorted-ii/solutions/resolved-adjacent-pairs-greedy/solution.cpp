class Solution {
    public: int minDeletionSize(vector<string>& strs){
        vector<bool> resolved(strs.size());
        int deleted=0;
        for(int col=0;col<(int)strs[0].size();++col){
            bool invalid=false;
            for(int row=1;row<(int)strs.size();++row)if(!resolved[row]&&strs[row-1][col]>strs[row][col]){
                invalid=true;
                break;
            }
            if(invalid){
                ++deleted;
                continue;
            }
            for(int row=1;row<(int)strs.size();++row)if(strs[row-1][col]<strs[row][col])resolved[row]=true;
        }
        return deleted;
    }
};
