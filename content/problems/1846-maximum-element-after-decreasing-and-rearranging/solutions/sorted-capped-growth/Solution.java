class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr){
        Arrays.sort(arr);
        int current=0;
        for(int value:arr)current=Math.min(value,current+1);
        return current;
    }
}
