class Solution { public int maxSubarrays(int[] nums){int current=-1,answer=0;for(int value:nums){current&=value;if(current==0){answer++;current=-1;}}return Math.max(answer,1);} }
