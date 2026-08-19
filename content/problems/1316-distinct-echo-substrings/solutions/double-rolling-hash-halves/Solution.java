class Solution {
    private static final long MOD1=1000000007L,MOD2=1000000009L,BASE=911382323L;
    public int distinctEchoSubstrings(String text){
        int n=text.length();
        long[] p1=new long[n+1],p2=new long[n+1],pow1=new long[n+1],pow2=new long[n+1];
        pow1[0]=pow2[0]=1;
        for(int i=0;i<n;i++){
            p1[i+1]=(p1[i]*BASE+text.charAt(i))%MOD1;
            p2[i+1]=(p2[i]*BASE+text.charAt(i))%MOD2;
            pow1[i+1]=pow1[i]*BASE%MOD1;
            pow2[i+1]=pow2[i]*BASE%MOD2;
        }
        Set<Long> seen=new HashSet<>();
        for(int half=1;half*2<=n;half++)for(int start=0;start+2*half<=n;start++){
            long a1=hash(p1,pow1,start,start+half,MOD1),b1=hash(p1,pow1,start+half,start+2*half,MOD1);
            if(a1!=b1)continue;
            long a2=hash(p2,pow2,start,start+half,MOD2),b2=hash(p2,pow2,start+half,start+2*half,MOD2);
            if(a2==b2)seen.add(a1*MOD2+a2);
        }
        return seen.size();
    }
    private long hash(long[] prefix,long[] power,int left,int right,long mod){
        return (prefix[right]-prefix[left]*power[right-left]%mod+mod)%mod;
    }
}
