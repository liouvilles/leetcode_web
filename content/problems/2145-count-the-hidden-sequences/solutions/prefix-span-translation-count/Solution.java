class Solution {
    public int numberOfArrays(int[] differences,int lower,int upper){
        long prefix=0,minimum=0,maximum=0;
        for(int difference:differences){
            prefix+=difference;
            minimum=Math.min(minimum,prefix);
            maximum=Math.max(maximum,prefix);
        }
        return (int)Math.max(0L,(long)upper-lower-(maximum-minimum)+1);
    }
}
