class Solution {
    public:long long maximumSubsequenceCount(string text,string pattern){
        long long first=0,second=0,existing=0;
        for(char ch:text){
            if(ch==pattern[1]){
                existing+=first;
                ++second;
            }
            if(ch==pattern[0])++first;
        }
        return existing+max(first,second);
    }
};
