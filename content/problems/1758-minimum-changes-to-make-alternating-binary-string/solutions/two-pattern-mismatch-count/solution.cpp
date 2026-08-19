class Solution {
    public: int minOperations(string text){
        int mismatch=0;
        for(int i=0;i<(int)text.size();++i)mismatch+=text[i]!='0'+i%2;
        return min(mismatch,(int)text.size()-mismatch);
    }
};
