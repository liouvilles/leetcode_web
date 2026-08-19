class Solution {
    private int solve(int[] a,int[] b,int lastA,int lastB){
        int operations=0;
        for(int i=0;i<a.length-1;i++){
            if(a[i]<=lastA&&b[i]<=lastB)continue;
            if(b[i]<=lastA&&a[i]<=lastB)operations++;
            else return 1000000000;
        }
        return operations;
    }
    public int minOperations(int[] nums1,int[] nums2){
        int n=nums1.length;
        int answer=Math.min(solve(nums1,nums2,nums1[n-1],nums2[n-1]),1+solve(nums1,nums2,nums2[n-1],nums1[n-1]));
        return answer>=1000000000?-1:answer;
    }
}
