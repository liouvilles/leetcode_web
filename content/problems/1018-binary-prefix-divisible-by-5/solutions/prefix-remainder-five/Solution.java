class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums){
        List<Boolean> answer=new ArrayList<>();
        int remainder=0;
        for(int bit:nums){
            remainder=(remainder*2+bit)%5;
            answer.add(remainder==0);
        }
        return answer;
    }
}
