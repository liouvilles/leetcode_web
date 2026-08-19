class Solution {
    private boolean possible(int[] price,int k,int distance){
        int count=1,last=price[0];
        for(int value:price)if(value-last>=distance){
            count++;
            last=value;
            if(count>=k)return true;
        }
        return count>=k;
    }
    public int maximumTastiness(int[] price,int k){
        Arrays.sort(price);
        int left=0,right=(price[price.length-1]-price[0])/(k-1);
        while(left<right){
            int middle=(left+right+1)>>>1;
            if(possible(price,k,middle))left=middle;
            else right=middle-1;
        }
        return left;
    }
}
