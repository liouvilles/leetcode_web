class Solution {
    public int[] numMovesStones(int a,int b,int c){
        int[] values={
            a,b,c
        };
        Arrays.sort(values);
        int maximum=values[2]-values[0]-2;
        int minimum=values[1]-values[0]==1&&values[2]-values[1]==1?0:values[1]-values[0]<=2||values[2]-values[1]<=2?1:2;
        return new int[]{
            minimum,maximum
        };
    }
}
