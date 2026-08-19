class Solution { fun maximizeGreatness(nums:IntArray):Int{nums.sort();var small=0;var answer=0;for(large in nums.indices)if(nums[large]>nums[small]){small++;answer++};return answer} }
