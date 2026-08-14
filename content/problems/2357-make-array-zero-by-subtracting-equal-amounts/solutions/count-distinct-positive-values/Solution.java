class Solution { public int minimumOperations(int[] nums){Set<Integer> positive=new HashSet<>();for(int value:nums)if(value>0)positive.add(value);return positive.size();} }
