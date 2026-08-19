class Solution {
    public int[] sumZero(int n){
        int[] answer=new int[n];
        int write=0;
        for(int value=1;value<=n/2;value++){
            answer[write++]=value;
            answer[write++]=-value;
        }
        if(n%2==1)answer[write]=0;
        return answer;
    }
}
