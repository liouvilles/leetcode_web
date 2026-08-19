class Solution {
    public boolean canBeEqual(int[] target,int[] arr){
        Map<Integer,Integer> count=new HashMap<>();
        for(int value:target)count.merge(value,1,Integer::sum);
        for(int value:arr)count.merge(value,-1,Integer::sum);
        return count.values().stream().allMatch(value->value==0);
    }
}
