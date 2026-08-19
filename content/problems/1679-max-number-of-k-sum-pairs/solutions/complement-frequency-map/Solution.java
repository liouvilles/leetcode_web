class Solution {
    public int maxOperations(int[] nums,int k){
        Map<Integer,Integer> available=new HashMap<>();
        int answer=0;
        for(int value:nums){
            int complement=k-value;
            if(available.getOrDefault(complement,0)>0){
                available.put(complement,available.get(complement)-1);
                answer++;
            }else available.put(value,available.getOrDefault(value,0)+1);
        }
        return answer;
    }
}
