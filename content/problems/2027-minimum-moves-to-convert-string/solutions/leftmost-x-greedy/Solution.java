class Solution {
    public int minimumMoves(String s){
        int answer=0;
        for(int index=0;index<s.length();)if(s.charAt(index)=='X'){
            answer++;
            index+=3;
        }else index++;
        return answer;
    }
}
