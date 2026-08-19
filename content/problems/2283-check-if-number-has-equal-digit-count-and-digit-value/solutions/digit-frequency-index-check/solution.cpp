class Solution {
    public:bool digitCount(string num){
        int count[10]={
        };
        for(char ch:num)++count[ch-'0'];
        for(int i=0;i<(int)num.size();++i)if(count[i]!=num[i]-'0')return false;
        return true;
    }
};
