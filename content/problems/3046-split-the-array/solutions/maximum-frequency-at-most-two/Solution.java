class Solution { public boolean isPossibleToSplit(int[] nums){int[] frequency=new int[101];for(int value:nums)if(++frequency[value]>2)return false;return true;} }
