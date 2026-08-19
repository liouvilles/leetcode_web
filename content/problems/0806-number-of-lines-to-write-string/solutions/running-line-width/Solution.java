class Solution {
    public int[] numberOfLines(int[] widths,String s){
        int lines=1,width=0;
        for(char c:s.toCharArray()){
            int next=widths[c-'a'];
            if(width+next>100){
                lines++;
                width=next;
            }else width+=next;
        }
        return new int[]{
            lines,width
        };
    }
}
