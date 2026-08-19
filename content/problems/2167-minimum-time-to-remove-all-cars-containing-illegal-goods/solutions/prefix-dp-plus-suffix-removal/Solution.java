class Solution {
    public int minimumTime(String s){
        int n=s.length(),leftCost=0,answer=n;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1')leftCost=Math.min(leftCost+2,i+1);
            answer=Math.min(answer,leftCost+n-1-i);
        }
        return answer;
    }
}
