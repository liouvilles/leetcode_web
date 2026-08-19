class Solution { public int findValueOfPartition(int[] nums){Arrays.sort(nums);int answer=Integer.MAX_VALUE;for(int i=1;i<nums.length;i++)answer=Math.min(answer,nums[i]-nums[i-1]);return answer;} }
