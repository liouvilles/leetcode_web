class Solution {
    public int sumOfUnique(int[] nums){
        Map<Integer,Integer> frequency=new HashMap<>();
        for(int value:nums)frequency.put(value,frequency.getOrDefault(value,0)+1);
        int answer=0;
        for(Map.Entry<Integer,Integer> entry:frequency.entrySet())if(entry.getValue()==1)answer+=entry.getKey();
        return answer;
    }
}
