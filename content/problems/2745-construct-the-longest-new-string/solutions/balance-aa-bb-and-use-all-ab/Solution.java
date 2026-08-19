class Solution {
    public int longestString(int x,int y,int z){
        int blocks=2*Math.min(x,y)+(x==y?0:1)+z;
        return blocks*2;
    }
}
