class Solution { public int minMoves2(int[] nums){Arrays.sort(nums);int median=nums[nums.length/2];long answer=0;for(int value:nums)answer+=Math.abs((long)value-median);return(int)answer;} }
