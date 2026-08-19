class Solution {
    public int numOfPairs(String[] nums,String target){
        Map<String,Integer> frequency=new HashMap<>();
        for(String value:nums)frequency.merge(value,1,Integer::sum);
        int answer=0;
        for(int split=1;split<target.length();split++){
            String left=target.substring(0,split),right=target.substring(split);
            int first=frequency.getOrDefault(left,0),second=frequency.getOrDefault(right,0);
            answer+=left.equals(right)?first*(first-1):first*second;
        }
        return answer;
    }
}
