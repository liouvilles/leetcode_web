class Solution {
    public int minimumPushes(String word){
        int full=word.length()/8,remaining=word.length()%8;
        return 8*full*(full+1)/2+(full+1)*remaining;
    }
}
