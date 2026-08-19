class Solution {
    public int maximumScore(int a,int b,int c){
        int total=a+b+c,maximum=Math.max(a,Math.max(b,c));
        return Math.min(total-maximum,total/2);
    }
}
