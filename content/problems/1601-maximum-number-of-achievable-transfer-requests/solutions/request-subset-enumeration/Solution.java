class Solution {
    public int maximumRequests(int n,int[][] requests){
        int answer=0,total=1<<requests.length;
        for(int mask=0;mask<total;mask++){
            int selected=Integer.bitCount(mask);
            if(selected<=answer)continue;
            int[] balance=new int[n];
            for(int i=0;i<requests.length;i++)if((mask&(1<<i))!=0){
                balance[requests[i][0]]--;
                balance[requests[i][1]]++;
            }
            boolean valid=true;
            for(int value:balance)if(value!=0){
                valid=false;
                break;
            }
            if(valid)answer=selected;
        }
        return answer;
    }
}
