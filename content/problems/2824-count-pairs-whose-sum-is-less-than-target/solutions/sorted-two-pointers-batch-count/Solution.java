class Solution {
    public int countPairs(List<Integer> nums,int target){
        Collections.sort(nums);
        int left=0,right=nums.size()-1,answer=0;
        while(left<right)if(nums.get(left)+nums.get(right)<target){
            answer+=right-left;
            left++;
        }else right--;
        return answer;
    }
}
