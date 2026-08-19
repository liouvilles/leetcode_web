class Solution { public boolean hasTrailingZeros(int[] nums){int even=0;for(int value:nums)if((value&1)==0&&++even==2)return true;return false;} }
