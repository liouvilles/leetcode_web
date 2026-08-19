class Solution {
    public int findShortestSubArray(int[] nums){
        Map<Integer,Integer> first=new HashMap<>(),count=new HashMap<>();
        int degree=0,length=0;
        for(int i=0;i<nums.length;i++){
            int value=nums[i];
            first.putIfAbsent(value,i);
            int frequency=count.getOrDefault(value,0)+1;
            count.put(value,frequency);
            int span=i-first.get(value)+1;
            if(frequency>degree){
                degree=frequency;
                length=span;
            }else if(frequency==degree)length=Math.min(length,span);
        }
        return length;
    }
}
