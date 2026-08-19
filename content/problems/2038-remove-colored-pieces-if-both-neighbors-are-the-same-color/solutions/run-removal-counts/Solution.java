class Solution {
    public boolean winnerOfGame(String colors){
        int alice=0,bob=0;
        for(int start=0;start<colors.length();){
            int end=start;
            while(end<colors.length()&&colors.charAt(end)==colors.charAt(start))end++;
            int moves=Math.max(0,end-start-2);
            if(colors.charAt(start)=='A')alice+=moves;
            else bob+=moves;
            start=end;
        }
        return alice>bob;
    }
}
