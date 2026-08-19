class Solution {
    public int maximumWealth(int[][] accounts){
        int answer=0;
        for(int[] customer:accounts)answer=Math.max(answer,Arrays.stream(customer).sum());
        return answer;
    }
}
