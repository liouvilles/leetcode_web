class Solution {
    public int countPrefixes(String[] words,String s){
        int answer=0;
        for(String word:words)if(s.startsWith(word))answer++;
        return answer;
    }
}
