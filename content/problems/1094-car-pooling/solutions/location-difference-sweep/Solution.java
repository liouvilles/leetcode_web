class Solution {
    public boolean carPooling(int[][] trips,int capacity){
        int[] difference=new int[1001];
        for(int[] trip:trips){
            difference[trip[1]]+=trip[0];
            difference[trip[2]]-=trip[0];
        }
        int onboard=0;
        for(int change:difference)if((onboard+=change)>capacity)return false;
        return true;
    }
}
