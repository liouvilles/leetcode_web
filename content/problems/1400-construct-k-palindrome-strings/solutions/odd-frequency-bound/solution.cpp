class Solution {
    public: bool canConstruct(string text,int k){
        if((int)text.size()<k)return false;
        int count[26]={
        };
        for(char value:text)++count[value-'a'];
        int odd=0;
        for(int frequency:count)odd+=frequency%2;
        return odd<=k;
    }
};
