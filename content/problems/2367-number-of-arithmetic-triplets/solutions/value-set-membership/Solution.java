class Solution {
    public int arithmeticTriplets(int[] nums,int diff){
        Set<Integer> values=new HashSet<>();
        for(int value:nums)values.add(value);
        int answer=0;
        for(int value:nums)if(values.contains(value+diff)&&values.contains(value+2*diff))answer++;
        return answer;
    }
}
