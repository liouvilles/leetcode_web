class Solution { public int findMaxConsecutiveOnes(int[] nums){int current=0,best=0;for(int value:nums){current=value==1?current+1:0;best=Math.max(best,current);}return best;} }
