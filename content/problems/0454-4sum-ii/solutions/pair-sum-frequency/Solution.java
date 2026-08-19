class Solution {
    public int fourSumCount(int[] nums1,int[] nums2,int[] nums3,int[] nums4){
        Map<Integer,Integer> counts=new HashMap<>();
        for(int a:nums1)for(int b:nums2)counts.put(a+b,counts.getOrDefault(a+b,0)+1);
        int answer=0;
        for(int c:nums3)for(int d:nums4)answer+=counts.getOrDefault(-c-d,0);
        return answer;
    }
}
