class Solution {
    public:int minimizedStringLength(string s){
        bool seen[26]={
        };
        int answer=0;
        for(char ch:s)if(!seen[ch-'a']){
            seen[ch-'a']=true;
            ++answer;
        }
        return answer;
    }
};
