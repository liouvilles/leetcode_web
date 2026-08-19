class Solution {
    public int longestSquareStreak(int[] nums){
        Arrays.sort(nums);
        Map<Integer,Integer> dp=new HashMap<>();
        int answer=1;
        for(int value:nums){
            int root=(int)Math.sqrt(value);
            int length=root*root==value&&dp.containsKey(root)?dp.get(root)+1:1;
            dp.put(value,length);
            answer=Math.max(answer,length);
        }
        return answer>=2?answer:-1;
    }
}
