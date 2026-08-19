class Solution {
    public int minEatingSpeed(int[] piles,int h){
        int low=1,high=Arrays.stream(piles).max().getAsInt();
        while(low<high){
            int middle=low+(high-low)/2;
            long hours=0;
            for(int pile:piles)hours+=(pile+middle-1)/middle;
            if(hours<=h)high=middle;
            else low=middle+1;
        }
        return low;
    }
}
