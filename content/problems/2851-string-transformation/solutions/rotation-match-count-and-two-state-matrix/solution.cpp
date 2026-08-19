class Solution {
    static constexpr long long MOD=1000000007;
    using Matrix=array<array<long long,2>,2>;
    Matrix multiply(Matrix a,Matrix b){
        Matrix c{
        };
        for(int i=0;i<2;++i)for(int j=0;j<2;++j)for(int p=0;p<2;++p)c[i][j]=(c[i][j]+a[i][p]*b[p][j])%MOD;
        return c;
    }
    Matrix power(long long exponent,int n){
        Matrix result={
            {
                {
                    1,0
                },{
                    0,1
                }
            }
        },base={
            {
                {
                    0,n-1
                },{
                    1,n-2
                }
            }
        };
        while(exponent){
            if(exponent&1)result=multiply(result,base);
            base=multiply(base,base);
            exponent>>=1;
        }
        return result;
    }
    int rotationMatches(string s,string t){
        int n=t.size();
        vector<int> lps(n);
        for(int i=1,length=0;i<n;)if(t[i]==t[length])lps[i++]=++length;
        else if(length)length=lps[length-1];
        else ++i;
        string text=s+s.substr(0,n-1);
        int matches=0;
        for(int i=0,j=0;i<(int)text.size();)if(text[i]==t[j]){
            ++i;
            ++j;
            if(j==n){
                ++matches;
                j=lps[j-1];
            }
        }else if(j)j=lps[j-1];
        else ++i;
        return matches;
    }
    public:int numberOfWays(string s,string t,long long k){
        int n=s.size();
        if(n==1)return s==t&&k==0;
        int matches=rotationMatches(s,t);
        Matrix matrix=power(k,n);
        long long same=matrix[0][0],other=matrix[1][0];
        return (s==t?same+(matches-1LL)*other:matches*other)%MOD;
    }
};
