class Solution {
    public int[] minOperations(String boxes){
        int n=boxes.length();
        int[] answer=new int[n];
        int balls=0,cost=0;
        for(int i=0;i<n;i++){
            answer[i]+=cost;
            if(boxes.charAt(i)=='1')balls++;
            cost+=balls;
        }
        balls=cost=0;
        for(int i=n-1;i>=0;i--){
            answer[i]+=cost;
            if(boxes.charAt(i)=='1')balls++;
            cost+=balls;
        }
        return answer;
    }
}
