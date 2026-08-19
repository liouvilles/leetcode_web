class Solution {
    public int longestEqualSubarray(List<Integer> nums,int k){
        Map<Integer,List<Integer>> positions=new HashMap<>();
        for(int i=0;i<nums.size();i++)positions.computeIfAbsent(nums.get(i),key->new ArrayList<>()).add(i);
        int answer=0;
        for(List<Integer> list:positions.values()){
            int left=0;
            for(int right=0;right<list.size();right++){
                while(list.get(right)-list.get(left)-(right-left)>k)left++;
                answer=Math.max(answer,right-left+1);
            }
        }
        return answer;
    }
}
