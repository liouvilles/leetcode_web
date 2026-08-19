class Solution {
    public long countSubstrings(String s,char c){
        long count=0;
        for(char letter:s.toCharArray())if(letter==c)count++;
        return count*(count+1)/2;
    }
}
