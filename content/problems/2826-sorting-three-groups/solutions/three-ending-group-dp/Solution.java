class Solution {
    public int minimumOperations(List<Integer> nums){
        int one=0,two=0,three=0;
        for(int value:nums){
            int nextOne=one+(value==1?0:1);
            int nextTwo=Math.min(one,two)+(value==2?0:1);
            int nextThree=Math.min(one,Math.min(two,three))+(value==3?0:1);
            one=nextOne;
            two=nextTwo;
            three=nextThree;
        }
        return Math.min(one,Math.min(two,three));
    }
}
