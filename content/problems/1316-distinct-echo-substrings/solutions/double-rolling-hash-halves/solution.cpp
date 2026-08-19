class Solution {
    public: int distinctEchoSubstrings(string text){
        const long long MOD1=1000000007,MOD2=1000000009,BASE=911382323;
        int n=text.size();
        vector<long long> p1(n+1),p2(n+1),pow1(n+1,1),pow2(n+1,1);
        for(int i=0;i<n;++i){
            p1[i+1]=(p1[i]*BASE+text[i])%MOD1;
            p2[i+1]=(p2[i]*BASE+text[i])%MOD2;
            pow1[i+1]=pow1[i]*BASE%MOD1;
            pow2[i+1]=pow2[i]*BASE%MOD2;
        }
        auto hash=[](vector<long long>& prefix,vector<long long>& power,int left,int right,long long mod){
            return (prefix[right]-prefix[left]*power[right-left]%mod+mod)%mod;
        };
        set<pair<long long,long long>> seen;
        for(int half=1;half*2<=n;++half)for(int start=0;start+2*half<=n;++start){
            long long a1=hash(p1,pow1,start,start+half,MOD1),b1=hash(p1,pow1,start+half,start+2*half,MOD1);
            if(a1!=b1)continue;
            long long a2=hash(p2,pow2,start,start+half,MOD2),b2=hash(p2,pow2,start+half,start+2*half,MOD2);
            if(a2==b2)seen.insert({
                a1,a2
            });
        }
        return seen.size();
    }
};
