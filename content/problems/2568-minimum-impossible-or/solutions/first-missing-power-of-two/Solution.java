class Solution {
    public int minImpossibleOR(int[] nums){
        Set<Integer> values=new HashSet<>();
        for(int value:nums)values.add(value);
        int candidate=1;
        while(values.contains(candidate))candidate<<=1;
        return candidate;
    }
}
