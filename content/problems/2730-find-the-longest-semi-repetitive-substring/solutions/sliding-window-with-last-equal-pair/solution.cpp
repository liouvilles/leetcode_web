class Solution {
    public:int longestSemiRepetitiveSubstring(string s){
        int left=0,lastRepeat=-1,answer=1;
        for(int right=1;right<(int)s.size();++right){
            if(s[right]==s[right-1]){
                if(lastRepeat>=left)left=lastRepeat;
                lastRepeat=right;
            }
            answer=max(answer,right-left+1);
        }
        return answer;
    }
};
