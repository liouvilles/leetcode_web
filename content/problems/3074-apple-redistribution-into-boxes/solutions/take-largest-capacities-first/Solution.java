class Solution {
    public int minimumBoxes(int[] apple,int[] capacity){
        int remaining=0;
        for(int count:apple)remaining+=count;
        Arrays.sort(capacity);
        for(int index=capacity.length-1;index>=0;index--){
            remaining-=capacity[index];
            if(remaining<=0)return capacity.length-index;
        }
        return capacity.length;
    }
}
