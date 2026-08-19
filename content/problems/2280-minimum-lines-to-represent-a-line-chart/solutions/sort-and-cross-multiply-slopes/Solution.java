class Solution {
    public int minimumLines(int[][] stockPrices){
        Arrays.sort(stockPrices,Comparator.comparingInt(a->a[0]));
        if(stockPrices.length==1)return 0;
        int answer=1;
        for(int i=2;i<stockPrices.length;i++){
            long dy1=stockPrices[i-1][1]-stockPrices[i-2][1],dx1=stockPrices[i-1][0]-stockPrices[i-2][0];
            long dy2=stockPrices[i][1]-stockPrices[i-1][1],dx2=stockPrices[i][0]-stockPrices[i-1][0];
            if(dy1*dx2!=dy2*dx1)answer++;
        }
        return answer;
    }
}
