class Solution {
    public int[] shortestToChar(String s,char c){
        int n=s.length(),previous=-n;
        int[] answer=new int[n];
        for(int i=0;i<n;i++){
            if(s.charAt(i)==c)previous=i;
            answer[i]=i-previous;
        }
        int next=2*n;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)==c)next=i;
            answer[i]=Math.min(answer[i],next-i);
        }
        return answer;
    }
}
