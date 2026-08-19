class Solution {
    public int countTriplets(int[] arr){
        int[] prefix=new int[arr.length+1];
        for(int i=0;i<arr.length;i++)prefix[i+1]=prefix[i]^arr[i];
        int answer=0;
        for(int i=0;i<arr.length;i++)for(int k=i+1;k<arr.length;k++)if(prefix[i]==prefix[k+1])answer+=k-i;
        return answer;
    }
}
