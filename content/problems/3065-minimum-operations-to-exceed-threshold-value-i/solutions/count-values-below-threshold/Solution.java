class Solution { public int minOperations(int[] nums,int k){int operations=0;for(int value:nums)if(value<k)operations++;return operations;} }
