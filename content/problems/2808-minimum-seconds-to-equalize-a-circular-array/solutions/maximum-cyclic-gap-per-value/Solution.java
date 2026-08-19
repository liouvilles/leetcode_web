class Solution {
    public int minimumSeconds(List<Integer> nums){
        Map<Integer,List<Integer>> positions=new HashMap<>();
        for(int i=0;i<nums.size();i++)positions.computeIfAbsent(nums.get(i),key->new ArrayList<>()).add(i);
        int answer=nums.size();
        for(List<Integer> list:positions.values()){
            int maximumGap=list.get(0)+nums.size()-list.get(list.size()-1);
            for(int i=1;i<list.size();i++)maximumGap=Math.max(maximumGap,list.get(i)-list.get(i-1));
            answer=Math.min(answer,maximumGap/2);
        }
        return answer;
    }
}
