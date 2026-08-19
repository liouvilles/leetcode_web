class Solution { public int maxOperations(int[] nums){int target=nums[0]+nums[1],answer=0;for(int i=0;i+1<nums.length;i+=2){if(nums[i]+nums[i+1]!=target)break;answer++;}return answer;} }
