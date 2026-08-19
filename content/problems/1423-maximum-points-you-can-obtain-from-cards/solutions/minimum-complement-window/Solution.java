class Solution {
    public int maxScore(int[] cardPoints,int k){
        int total=Arrays.stream(cardPoints).sum(),length=cardPoints.length-k;
        if(length==0)return total;
        int window=0;
        for(int i=0;i<length;i++)window+=cardPoints[i];
        int minimum=window;
        for(int right=length;right<cardPoints.length;right++){
            window+=cardPoints[right]-cardPoints[right-length];
            minimum=Math.min(minimum,window);
        }
        return total-minimum;
    }
}
