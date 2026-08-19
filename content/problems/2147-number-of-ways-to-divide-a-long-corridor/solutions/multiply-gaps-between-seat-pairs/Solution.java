class Solution {
    public int numberOfWays(String corridor){
        long ways=1;
        int seats=0,previousSecond=-1;
        for(int i=0;i<corridor.length();i++)if(corridor.charAt(i)=='S'){
            seats++;
            if(seats>2&&(seats&1)==1)ways=ways*(i-previousSecond)%1_000_000_007;
            if((seats&1)==0)previousSecond=i;
        }
        return seats>0&&(seats&1)==0?(int)ways:0;
    }
}
