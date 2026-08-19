class Solution {
    public int threeSumMulti(int[] arr,int target){
        long mod=1000000007L,answer=0;
        long[] count=new long[101];
        for(int value:arr)count[value]++;
        for(int a=0;a<=100;a++)for(int b=a;b<=100;b++){
            int c=target-a-b;
            if(c<b||c>100)continue;
            long ways;
            if(a==b&&b==c)ways=count[a]*(count[a]-1)*(count[a]-2)/6;
            else if(a==b)ways=count[a]*(count[a]-1)/2*count[c];
            else if(b==c)ways=count[a]*count[b]*(count[b]-1)/2;
            else ways=count[a]*count[b]*count[c];
            answer=(answer+ways)%mod;
        }
        return(int)answer;
    }
}
