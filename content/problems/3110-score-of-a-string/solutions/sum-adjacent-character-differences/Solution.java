class Solution {
    public int scoreOfString(String s){
        int answer=0;
        for(int index=1;index<s.length();index++)answer+=Math.abs(s.charAt(index)-s.charAt(index-1));
        return answer;
    }
}
