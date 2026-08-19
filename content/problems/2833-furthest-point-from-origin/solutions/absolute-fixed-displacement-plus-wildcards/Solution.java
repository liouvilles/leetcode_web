class Solution {
    public int furthestDistanceFromOrigin(String moves){
        int displacement=0,wildcards=0;
        for(char move:moves.toCharArray())if(move=='L')displacement--;
        else if(move=='R')displacement++;
        else wildcards++;
        return Math.abs(displacement)+wildcards;
    }
}
