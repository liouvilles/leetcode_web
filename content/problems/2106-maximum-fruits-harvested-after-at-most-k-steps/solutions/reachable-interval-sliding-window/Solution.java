class Solution {
    private int cost(int left,int right,int start){
        if(right<=start)return start-left;
        if(left>=start)return right-start;
        int a=start-left,b=right-start;
        return Math.min(2*a+b,a+2*b);
    }
    public int maxTotalFruits(int[][] fruits,int startPos,int k){
        int left=0,sum=0,answer=0;
        for(int right=0;right<fruits.length;right++){
            sum+=fruits[right][1];
            while(left<=right&&cost(fruits[left][0],fruits[right][0],startPos)>k)sum-=fruits[left++][1];
            answer=Math.max(answer,sum);
        }
        return answer;
    }
}
