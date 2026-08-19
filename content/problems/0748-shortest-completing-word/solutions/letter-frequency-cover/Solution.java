class Solution {
    public String shortestCompletingWord(String licensePlate,String[] words){
        int[] required=count(licensePlate);
        String answer=null;
        for(String word:words)if((answer==null||word.length()<answer.length())&&covers(count(word),required))answer=word;
        return answer;
    }
    private int[] count(String value){
        int[] counts=new int[26];
        for(char raw:value.toCharArray()){
            char c=Character.toLowerCase(raw);
            if(c>='a'&&c<='z')counts[c-'a']++;
        }
        return counts;
    }
    private boolean covers(int[] available,int[] required){
        for(int i=0;i<26;i++)if(available[i]<required[i])return false;
        return true;
    }
}
