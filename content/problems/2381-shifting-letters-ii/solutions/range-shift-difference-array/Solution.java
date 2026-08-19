class Solution {
    public String shiftingLetters(String s,int[][] shifts){
        int[] difference=new int[s.length()+1];
        for(int[] shift:shifts){
            int delta=shift[2]==1?1:-1;
            difference[shift[0]]+=delta;
            difference[shift[1]+1]-=delta;
        }
        char[] answer=s.toCharArray();
        int total=0;
        for(int i=0;i<answer.length;i++){
            total+=difference[i];
            answer[i]=(char)('a'+(answer[i]-'a'+total%26+26)%26);
        }
        return new String(answer);
    }
}
