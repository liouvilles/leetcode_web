class Solution {
    public int maximumCandies(int[] candies,long k){
        int left=0,right=Arrays.stream(candies).max().getAsInt();
        while(left<right){
            int middle=left+(right-left+1)/2;
            long pieces=0;
            for(int value:candies){
                pieces+=value/middle;
                if(pieces>=k)break;
            }
            if(pieces>=k)left=middle;
            else right=middle-1;
        }
        return left;
    }
}
