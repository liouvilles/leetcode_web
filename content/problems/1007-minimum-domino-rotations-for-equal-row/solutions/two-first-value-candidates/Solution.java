class Solution {
    public int minDominoRotations(int[] tops,int[] bottoms){
        int answer=Math.min(check(tops[0],tops,bottoms),check(bottoms[0],tops,bottoms));
        return answer==Integer.MAX_VALUE?-1:answer;
    }
    private int check(int target,int[] tops,int[] bottoms){
        int top=0,bottom=0;
        for(int i=0;i<tops.length;i++){
            if(tops[i]!=target&&bottoms[i]!=target)return Integer.MAX_VALUE;
            if(tops[i]!=target)top++;
            if(bottoms[i]!=target)bottom++;
        }
        return Math.min(top,bottom);
    }
}
