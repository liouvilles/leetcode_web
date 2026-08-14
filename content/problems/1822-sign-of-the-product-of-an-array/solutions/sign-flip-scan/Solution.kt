class Solution { fun arraySign(nums:IntArray):Int{var sign=1;for(value in nums){if(value==0)return 0;if(value<0)sign=-sign};return sign} }
