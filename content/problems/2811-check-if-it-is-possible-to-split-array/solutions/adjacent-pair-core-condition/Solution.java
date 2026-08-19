class Solution { public boolean canSplitArray(List<Integer> nums,int m){if(nums.size()<=2)return true;for(int i=1;i<nums.size();i++)if(nums.get(i-1)+nums.get(i)>=m)return true;return false;} }
