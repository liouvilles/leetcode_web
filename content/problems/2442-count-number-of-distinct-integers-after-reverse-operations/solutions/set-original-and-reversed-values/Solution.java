class Solution {
    public int countDistinctIntegers(int[] nums){
        Set<Integer> values=new HashSet<>();
        for(int value:nums){
            values.add(value);
            int x=value,reversed=0;
            while(x>0){
                reversed=reversed*10+x%10;
                x/=10;
            }
            values.add(reversed);
        }
        return values.size();
    }
}
