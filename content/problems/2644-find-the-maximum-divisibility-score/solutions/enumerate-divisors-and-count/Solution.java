class Solution {
    public int maxDivScore(int[] nums,int[] divisors){
        int bestScore=-1,answer=Integer.MAX_VALUE;
        for(int divisor:divisors){
            int score=0;
            for(int value:nums)if(value%divisor==0)score++;
            if(score>bestScore||score==bestScore&&divisor<answer){
                bestScore=score;
                answer=divisor;
            }
        }
        return answer;
    }
}
