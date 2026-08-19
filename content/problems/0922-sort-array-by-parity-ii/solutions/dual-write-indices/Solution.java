class Solution {
    public int[] sortArrayByParityII(int[] nums){
        int[] answer=new int[nums.length];
        int even=0,odd=1;
        for(int value:nums)if(value%2==0){
            answer[even]=value;
            even+=2;
        }else{
            answer[odd]=value;
            odd+=2;
        }
        return answer;
    }
}
