class Solution {
    public int minimumTimeToInitialState(String word,int k){
        int n=word.length();
        int[] z=new int[n];
        for(int index=1,left=0,right=0;index<n;index++){
            if(index<=right)z[index]=Math.min(right-index+1,z[index-left]);
            while(index+z[index]<n&&word.charAt(z[index])==word.charAt(index+z[index]))z[index]++;
            if(index+z[index]-1>right){
                left=index;
                right=index+z[index]-1;
            }
        }
        for(int shift=k;shift<n;shift+=k)if(z[shift]>=n-shift)return shift/k;
        return (n+k-1)/k;
    }
}
