class Solution {
    private boolean feasible(int[] bloomDay,int m,int k,int day){
        int bouquets=0,consecutive=0;
        for(int bloom:bloomDay){
            if(bloom<=day){
                if(++consecutive==k){
                    bouquets++;
                    consecutive=0;
                }
            }else consecutive=0;
        }
        return bouquets>=m;
    }
    public int minDays(int[] bloomDay,int m,int k){
        if((long)m*k>bloomDay.length)return -1;
        int left=Arrays.stream(bloomDay).min().getAsInt(),right=Arrays.stream(bloomDay).max().getAsInt();
        while(left<right){
            int middle=left+(right-left)/2;
            if(feasible(bloomDay,m,k,middle))right=middle;
            else left=middle+1;
        }
        return left;
    }
}
