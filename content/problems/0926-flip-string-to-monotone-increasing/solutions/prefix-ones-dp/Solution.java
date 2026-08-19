class Solution {
    public int minFlipsMonoIncr(String s){
        int ones=0,flips=0;
        for(char ch:s.toCharArray())if(ch=='1')ones++;
        else flips=Math.min(flips+1,ones);
        return flips;
    }
}
