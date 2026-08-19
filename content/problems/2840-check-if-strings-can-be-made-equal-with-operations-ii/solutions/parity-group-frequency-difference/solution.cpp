class Solution {
    public:bool checkStrings(string s1,string s2){
        int count[2][26]={
        };
        for(int i=0;i<(int)s1.size();++i){
            ++count[i%2][s1[i]-'a'];
            --count[i%2][s2[i]-'a'];
        }
        for(auto& row:count)for(int value:row)if(value)return false;
        return true;
    }
};
