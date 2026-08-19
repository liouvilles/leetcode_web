class Solution {
    private int digitSum(int value){
        int sum=0;
        while(value>0){
            sum+=value%10;
            value/=10;
        }
        return sum;
    }
    public int maximumSum(int[] nums){
        Map<Integer,Integer> maximum=new HashMap<>();
        int answer=-1;
        for(int value:nums){
            int sum=digitSum(value);
            if(maximum.containsKey(sum))answer=Math.max(answer,value+maximum.get(sum));
            maximum.put(sum,Math.max(maximum.getOrDefault(sum,0),value));
        }
        return answer;
    }
}
