class Solution {
    public double[] sampleStats(int[] count){
        int minimum=-1,maximum=0,mode=0,total=0;
        long sum=0;
        for(int value=0;value<count.length;value++)if(count[value]>0){
            if(minimum<0)minimum=value;
            maximum=value;
            total+=count[value];
            sum+=(long)value*count[value];
            if(count[value]>count[mode])mode=value;
        }
        double median=(kth(count,(total+1)/2)+kth(count,(total+2)/2))/2.0;
        return new double[]{
            minimum,maximum,(double)sum/total,median,mode
        };
    }
    private int kth(int[] count,int rank){
        int cumulative=0;
        for(int value=0;value<count.length;value++){
            cumulative+=count[value];
            if(cumulative>=rank)return value;
        }
        return -1;
    }
}
