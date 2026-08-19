class Solution {
    public int boxDelivering(int[][] boxes,int portsCount,int maxBoxes,int maxWeight){
        int n=boxes.length;
        long[] weight=new long[n+1];
        int[] change=new int[n+2];
        for(int i=1;i<=n;i++){
            weight[i]=weight[i-1]+boxes[i-1][1];
            change[i]=change[i-1]+(i>1&&boxes[i-1][0]!=boxes[i-2][0]?1:0);
        }
        change[n+1]=change[n];
        int[] dp=new int[n+1];
        Deque<Integer> deque=new ArrayDeque<>();
        deque.offerLast(0);
        for(int i=1;i<=n;i++){
            while(i-deque.peekFirst()>maxBoxes||weight[i]-weight[deque.peekFirst()]>maxWeight)deque.pollFirst();
            int j=deque.peekFirst();
            dp[i]=dp[j]+change[i]-change[j+1]+2;
            if(i<n){
                int value=dp[i]-change[i+1];
                while(!deque.isEmpty()&&dp[deque.peekLast()]-change[deque.peekLast()+1]>=value)deque.pollLast();
                deque.offerLast(i);
            }
        }
        return dp[n];
    }
}
