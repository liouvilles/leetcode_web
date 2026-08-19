class Solution {
    public int minOperations(int[] nums,int k){
        int xor=k;
        for(int value:nums)xor^=value;
        return Integer.bitCount(xor);
    }
}
