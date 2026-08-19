class Solution {
    public int maximumWhiteTiles(int[][] tiles,int carpetLen){
        Arrays.sort(tiles,Comparator.comparingInt(a->a[0]));
        int right=0,full=0,answer=0;
        for(int left=0;left<tiles.length;left++){
            int end=tiles[left][0]+carpetLen-1;
            while(right<tiles.length&&tiles[right][1]<=end){
                full+=tiles[right][1]-tiles[right][0]+1;
                right++;
            }
            int covered=full;
            if(right<tiles.length&&tiles[right][0]<=end)covered+=end-tiles[right][0]+1;
            answer=Math.max(answer,covered);
            if(right>left)full-=tiles[left][1]-tiles[left][0]+1;
            else right=left+1;
        }
        return Math.min(answer,carpetLen);
    }
}
