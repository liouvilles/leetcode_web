class Solution {
    public int[] arrayChange(int[] nums,int[][] operations){
        Map<Integer,Integer> position=new HashMap<>();
        for(int i=0;i<nums.length;i++)position.put(nums[i],i);
        for(int[] operation:operations){
            int index=position.remove(operation[0]);
            nums[index]=operation[1];
            position.put(operation[1],index);
        }
        return nums;
    }
}
