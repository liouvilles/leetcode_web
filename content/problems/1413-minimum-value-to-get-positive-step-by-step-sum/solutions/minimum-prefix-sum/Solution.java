class Solution {
    public int minStartValue(int[] nums){
        int prefix=0,minimum=0;
        for(int value:nums){
            prefix+=value;
            minimum=Math.min(minimum,prefix);
        }
        return 1-minimum;
    }
}
