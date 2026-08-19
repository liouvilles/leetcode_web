class Solution {
    public: bool canConvertString(string s,string t,int k){
        if(s.size()!=t.size())return false;
        int count[26]={
        };
        for(int i=0;i<(int)s.size();++i){
            int difference=(t[i]-s[i]+26)%26;
            if(!difference)continue;
            int scheduled=difference+26*count[difference]++;
            if(scheduled>k)return false;
        }
        return true;
    }
};
