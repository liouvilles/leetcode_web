class Solution {
    static final int MOD=1_000_000_007;
    String value;
    short[][] lcp;
    private boolean lessOrEqual(int first,int second,int length){
        int common=lcp[first][second];
        return common>=length||value.charAt(first+common)<=value.charAt(second+common);
    }
    public int numberOfCombinations(String num){
        if(num.charAt(0)=='0')return 0;
        value=num;
        int n=num.length();
        lcp=new short[n+1][n+1];
        for(int first=n-1;first>=0;first--)for(int second=n-1;second>=0;second--)if(num.charAt(first)==num.charAt(second))lcp[first][second]=(short)(lcp[first+1][second+1]+1);
        int[][] prefix=new int[n+1][n+1];
        for(int end=1;end<=n;end++)for(int length=1;length<=end;length++){
            int start=end-length;
            long ways=0;
            if(num.charAt(start)!='0'){
                if(start==0)ways=1;
                else{
                    ways=prefix[start][Math.min(length-1,start)];
                    if(length<=start&&lessOrEqual(start-length,start,length)){
                        int equal=prefix[start][length]-prefix[start][length-1];
                        if(equal<0)equal+=MOD;
                        ways+=equal;
                    }
                }
            }
            prefix[end][length]=(int)((prefix[end][length-1]+ways)%MOD);
        }
        return prefix[n][n];
    }
}
