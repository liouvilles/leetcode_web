class Solution {
    static const long long MOD=1'000'000'007;
    long long power(long long base,long long exponent){
        long long result=1;
        while(exponent){
            if(exponent&1)result=result*base%MOD;
            base=base*base%MOD;
            exponent>>=1;
        }
        return result;
    }
    public:int countAnagrams(string s){
        vector<long long> factorial(s.size()+1,1);
        for(int i=1;i<(int)factorial.size();++i)factorial[i]=factorial[i-1]*i%MOD;
        stringstream stream(s);
        string word;
        long long answer=1;
        while(stream>>word){
            int frequency[26]={
            };
            for(char character:word)++frequency[character-'a'];
            long long ways=factorial[word.size()];
            for(int count:frequency)ways=ways*power(factorial[count],MOD-2)%MOD;
            answer=answer*ways%MOD;
        }
        return answer;
    }
};
