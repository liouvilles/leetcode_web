class Solution {
    public int maxChunksToSorted(int[] arr){
        int n=arr.length;
        int[] prefix=new int[n],suffix=new int[n];
        prefix[0]=arr[0];
        for(int i=1;i<n;i++)prefix[i]=Math.max(prefix[i-1],arr[i]);
        suffix[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)suffix[i]=Math.min(suffix[i+1],arr[i]);
        int answer=1;
        for(int i=0;i+1<n;i++)if(prefix[i]<=suffix[i+1])answer++;
        return answer;
    }
}
