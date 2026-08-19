class Solution {
    public long[] kthPalindrome(int[] queries,int intLength){
        int halfLength=(intLength+1)/2;
        long start=1;
        for(int i=1;i<halfLength;i++)start*=10;
        long limit=9*start;
        long[] answer=new long[queries.length];
        for(int i=0;i<queries.length;i++){
            long offset=queries[i]-1L;
            if(offset>=limit){
                answer[i]=-1;
                continue;
            }
            long half=start+offset,result=half,mirror=intLength%2==1?half/10:half;
            while(mirror>0){
                result=result*10+mirror%10;
                mirror/=10;
            }
            answer[i]=result;
        }
        return answer;
    }
}
