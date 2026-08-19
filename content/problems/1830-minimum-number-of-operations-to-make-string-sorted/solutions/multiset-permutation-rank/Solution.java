class Solution {
    static final long MOD=1_000_000_007L;
    private long power(long base,long exponent){
        long answer=1;
        while(exponent>0){
            if((exponent&1)==1)answer=answer*base%MOD;
            base=base*base%MOD;
            exponent>>=1;
        }
        return answer;
    }
    public int makeStringSorted(String text){
        int n=text.length();
        long[] factorial=new long[n+1],inverse=new long[n+1];
        factorial[0]=1;
        for(int i=1;i<=n;i++)factorial[i]=factorial[i-1]*i%MOD;
        inverse[n]=power(factorial[n],MOD-2);
        for(int i=n;i>0;i--)inverse[i-1]=inverse[i]*i%MOD;
        int[] count=new int[26];
        for(char c:text.toCharArray())count[c-'a']++;
        long answer=0;
        for(int position=0;position<n;position++){
            long base=factorial[n-position-1];
            for(int value:count)base=base*inverse[value]%MOD;
            int smaller=0,letter=text.charAt(position)-'a';
            for(int c=0;c<letter;c++)smaller+=count[c];
            answer=(answer+base*smaller)%MOD;
            count[letter]--;
        }
        return (int)answer;
    }
}
