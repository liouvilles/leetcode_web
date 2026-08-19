class Solution {
    public: int distinctSubseqII(string s){
        const long long mod=1000000007;
        long long total=0,ending[26]={
        };
        for(char ch:s){
            int index=ch-'a';
            long long next=(2*total+1-ending[index]+mod)%mod;
            ending[index]=(total+1)%mod;
            total=next;
        }
        return total;
    }
};
