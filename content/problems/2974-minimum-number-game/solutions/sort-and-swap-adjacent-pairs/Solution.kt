class Solution { fun numberGame(nums:IntArray):IntArray{nums.sort();for(i in nums.indices step 2){val value=nums[i];nums[i]=nums[i+1];nums[i+1]=value};return nums} }
