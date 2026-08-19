class Solution {
    public int sumOddLengthSubarrays(int[] arr){
        int answer=0,n=arr.length;
        for(int i=0;i<n;i++){
            int total=(i+1)*(n-i);
            answer+=arr[i]*((total+1)/2);
        }
        return answer;
    }
}
