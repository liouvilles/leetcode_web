class Solution {
    public: int minDeletionSize(vector<string>& strs){
        int deleted=0;
        for(int col=0;col<(int)strs[0].size();++col)for(int row=1;row<(int)strs.size();++row)if(strs[row-1][col]>strs[row][col]){
            ++deleted;
            break;
        }
        return deleted;
    }
};
