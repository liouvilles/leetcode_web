class Solution {
    public int[] findIntersectionValues(int[] nums1,int[] nums2){
        Set<Integer> first=new HashSet<>(),second=new HashSet<>();
        for(int value:nums1)first.add(value);
        for(int value:nums2)second.add(value);
        int[] answer=new int[2];
        for(int value:nums1)if(second.contains(value))answer[0]++;
        for(int value:nums2)if(first.contains(value))answer[1]++;
        return answer;
    }
}
