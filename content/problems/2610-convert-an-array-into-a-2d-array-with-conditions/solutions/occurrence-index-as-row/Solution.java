class Solution {
    public List<List<Integer>> findMatrix(int[] nums){
        Map<Integer,Integer> frequency=new HashMap<>();
        List<List<Integer>> answer=new ArrayList<>();
        for(int value:nums){
            int row=frequency.getOrDefault(value,0);
            if(row==answer.size())answer.add(new ArrayList<>());
            answer.get(row).add(value);
            frequency.put(value,row+1);
        }
        return answer;
    }
}
