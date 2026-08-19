class Solution {
    public int countMatchingSubarrays(int[] nums,int[] pattern){
        int answer=0;
        for(int start=0;start+pattern.length<nums.length;start++){
            boolean matches=true;
            for(int index=0;index<pattern.length;index++)if(Integer.compare(nums[start+index+1],nums[start+index])!=pattern[index]){
                matches=false;
                break;
            }
            if(matches)answer++;
        }
        return answer;
    }
}
