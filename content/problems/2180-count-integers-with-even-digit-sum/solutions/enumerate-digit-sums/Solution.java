class Solution {
    public int countEven(int num){
        int answer=0;
        for(int value=1;value<=num;value++){
            int current=value,sum=0;
            while(current>0){
                sum+=current%10;
                current/=10;
            }
            if(sum%2==0)answer++;
        }
        return answer;
    }
}
