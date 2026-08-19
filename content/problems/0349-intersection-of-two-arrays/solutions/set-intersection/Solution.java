class Solution {
    public int[] intersection(int[] nums1,int[] nums2){
        Set<Integer> first=new HashSet<>();
        for(int value:nums1)first.add(value);
        Set<Integer> common=new TreeSet<>();
        for(int value:nums2)if(first.contains(value))common.add(value);
        return common.stream().mapToInt(Integer::intValue).toArray();
    }
}
