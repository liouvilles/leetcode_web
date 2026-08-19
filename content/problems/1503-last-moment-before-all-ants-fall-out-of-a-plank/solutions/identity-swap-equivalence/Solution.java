class Solution {
    public int getLastMoment(int n,int[] left,int[] right){
        int answer=0;
        for(int position:left)answer=Math.max(answer,position);
        for(int position:right)answer=Math.max(answer,n-position);
        return answer;
    }
}
