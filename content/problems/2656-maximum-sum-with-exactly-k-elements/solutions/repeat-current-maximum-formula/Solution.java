class Solution {
    public int maximizeSum(int[] nums,int k){
        int maximum=Arrays.stream(nums).max().getAsInt();
        return k*maximum+k*(k-1)/2;
    }
}
