class Solution {
    public double averageWaitingTime(int[][] customers){
        long finish=0,totalWait=0;
        for(int[] customer:customers){
            finish=Math.max(finish,customer[0])+customer[1];
            totalWait+=finish-customer[0];
        }
        return (double)totalWait/customers.length;
    }
}
