class Solution {
    public boolean makeEqual(String[] words){
        int[] frequency=new int[26];
        for(String word:words)for(char letter:word.toCharArray())frequency[letter-'a']++;
        for(int count:frequency)if(count%words.length!=0)return false;
        return true;
    }
}
