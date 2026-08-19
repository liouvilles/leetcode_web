class Solution {
    private long gcd(long first,long second){
        while(second!=0){
            long value=first%second;
            first=second;
            second=value;
        }
        return first;
    }
    private long count(int[] coins,long limit){
        long total=0;
        for(int mask=1;mask<(1<<coins.length);mask++){
            long lcm=1;
            int bits=0;
            boolean tooLarge=false;
            for(int index=0;index<coins.length;index++)if((mask&(1<<index))!=0){
                bits++;
                long divisor=gcd(lcm,coins[index]);
                if(lcm/divisor>limit/coins[index]){
                    tooLarge=true;
                    break;
                }
                lcm=lcm/divisor*coins[index];
            }
            if(!tooLarge){
                long occurrences=limit/lcm;
                total+=(bits&1)==1?occurrences:-occurrences;
            }
        }
        return total;
    }
    public long findKthSmallest(int[] coins,int k){
        int minimum=Arrays.stream(coins).min().getAsInt();
        long low=1,high=(long)minimum*k;
        while(low<high){
            long middle=low+(high-low)/2;
            if(count(coins,middle)>=k)high=middle;
            else low=middle+1;
        }
        return low;
    }
}
