class Solution {
    public int[] advantageCount(int[] nums1,int[] nums2){
        Arrays.sort(nums1);
        Integer[] order=new Integer[nums2.length];
        for(int i=0;i<order.length;i++)order[i]=i;
        Arrays.sort(order,Comparator.comparingInt(i->nums2[i]));
        int[] answer=new int[nums1.length];
        int left=0,right=nums1.length-1;
        for(int value:nums1)if(value>nums2[order[left]])answer[order[left++]]=value;
        else answer[order[right--]]=value;
        return answer;
    }
}
