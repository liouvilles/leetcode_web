class Solution {
    public:bool isItPossible(string word1,string word2){
        int first[26]={
        },second[26]={
        };
        for(char c:word1)++first[c-'a'];
        for(char c:word2)++second[c-'a'];
        int distinct1=0,distinct2=0;
        for(int i=0;i<26;++i){
            distinct1+=first[i]>0;
            distinct2+=second[i]>0;
        }
        for(int i=0;i<26;++i)if(first[i])for(int j=0;j<26;++j)if(second[j]){
            if(i==j){
                if(distinct1==distinct2)return true;
                continue;
            }
            int next1=distinct1-(first[i]==1)+(first[j]==0),next2=distinct2-(second[j]==1)+(second[i]==0);
            if(next1==next2)return true;
        }
        return false;
    }
};
