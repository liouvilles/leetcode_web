class Solution {
    public int xorBeauty(int[] nums){
        int answer=0;
        for(int value:nums)answer^=value;
        return answer;
    }
}
