class Solution { fun averageValue(nums:IntArray):Int{var sum=0;var count=0;for(value in nums)if(value%6==0){sum+=value;count++};return if(count==0)0 else sum/count} }
