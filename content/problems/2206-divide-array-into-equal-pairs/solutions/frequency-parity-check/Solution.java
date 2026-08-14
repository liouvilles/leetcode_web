class Solution { public boolean divideArray(int[] nums){Set<Integer> odd=new HashSet<>();for(int value:nums)if(!odd.add(value))odd.remove(value);return odd.isEmpty();} }
