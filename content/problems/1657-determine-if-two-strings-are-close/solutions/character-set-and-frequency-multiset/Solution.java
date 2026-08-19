class Solution {
    public boolean closeStrings(String word1,String word2){
        if(word1.length()!=word2.length())return false;
        int[] first=new int[26],second=new int[26];
        for(char letter:word1.toCharArray())first[letter-'a']++;
        for(char letter:word2.toCharArray())second[letter-'a']++;
        for(int i=0;i<26;i++)if((first[i]==0)!=(second[i]==0))return false;
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first,second);
    }
}
