class Solution {
    public: string reverseStr(string s,int k){
        for(int start=0;start<(int)s.size();start+=2*k)reverse(s.begin()+start,s.begin()+min(start+k,(int)s.size()));
        return s;
    }
};
