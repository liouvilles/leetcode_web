class Solution {
    public boolean isCovered(int[][] ranges,int left,int right){
        int[] difference=new int[52];
        for(int[] range:ranges){
            difference[range[0]]++;
            difference[range[1]+1]--;
        }
        int coverage=0;
        for(int value=1;value<=right;value++){
            coverage+=difference[value];
            if(value>=left&&coverage==0)return false;
        }
        return true;
    }
}
