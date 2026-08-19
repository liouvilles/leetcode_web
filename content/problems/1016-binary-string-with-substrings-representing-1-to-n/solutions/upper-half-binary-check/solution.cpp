class Solution {
    public: bool queryString(string s,int n){
        for(int value=n;value>n/2;--value){
            string binary;
            for(int x=value;x;x>>=1)binary.push_back('0'+(x&1));
            reverse(binary.begin(),binary.end());
            if(s.find(binary)==string::npos)return false;
        }
        return true;
    }
};
