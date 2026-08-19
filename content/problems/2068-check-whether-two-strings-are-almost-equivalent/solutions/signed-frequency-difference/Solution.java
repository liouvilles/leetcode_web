class Solution {
    public boolean checkAlmostEquivalent(String word1,String word2){
        int[] difference=new int[26];
        for(char value:word1.toCharArray())difference[value-'a']++;
        for(char value:word2.toCharArray())difference[value-'a']--;
        for(int value:difference)if(Math.abs(value)>3)return false;
        return true;
    }
}
