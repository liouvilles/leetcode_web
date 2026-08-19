class Solution { fun returnToBoundaryCount(nums:IntArray):Int{var position=0;var answer=0;for(distance in nums){position+=distance;if(position==0)answer++};return answer} }
