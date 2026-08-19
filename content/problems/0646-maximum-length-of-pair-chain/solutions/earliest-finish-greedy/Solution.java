class Solution {
    public int findLongestChain(int[][] pairs){
        Arrays.sort(pairs,Comparator.comparingInt(pair->pair[1]));
        int end=Integer.MIN_VALUE,length=0;
        for(int[] pair:pairs)if(pair[0]>end){
            length++;
            end=pair[1];
        }
        return length;
    }
}
