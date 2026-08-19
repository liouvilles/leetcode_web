class Solution {
    bool isVowel(char value){
        return value=='a'||value=='e'||value=='i'||value=='o'||value=='u';
    }
    int period(int value){
        int base=1,remaining=value;
        for(int factor=2;factor*factor<=remaining;++factor){
            int exponent=0;
            while(remaining%factor==0){
                remaining/=factor;
                ++exponent;
            }
            for(int count=0;count<(exponent+1)/2;++count)base*=factor;
        }
        if(remaining>1)base*=remaining;
        return 2*base;
    }
    public:long long beautifulSubstrings(string s,int k){
        int n=s.size(),mod=period(k),balance=0;
        unordered_map<long long,long long> frequency;
        frequency[1LL*n*mod]=1;
        long long answer=0;
        for(int position=1;position<=n;++position){
            balance+=isVowel(s[position-1])?1:-1;
            long long key=1LL*(balance+n)*mod+position%mod;
            answer+=frequency[key];
            ++frequency[key];
        }
        return answer;
    }
};
