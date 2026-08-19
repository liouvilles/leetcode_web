class Solution {
    public int maxDistToClosest(int[] seats){
        int answer=0,previous=-1;
        for(int i=0;i<seats.length;i++)if(seats[i]==1){
            answer=previous<0?i:Math.max(answer,(i-previous)/2);
            previous=i;
        }
        return Math.max(answer,seats.length-1-previous);
    }
}
