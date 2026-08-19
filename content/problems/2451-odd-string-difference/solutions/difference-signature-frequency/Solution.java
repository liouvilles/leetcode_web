class Solution {
    private String key(String word){
        StringBuilder value=new StringBuilder();
        for(int i=1;i<word.length();i++)value.append(word.charAt(i)-word.charAt(i-1)).append(',');
        return value.toString();
    }
    public String oddString(String[] words){
        Map<String,Integer> frequency=new HashMap<>();
        for(String word:words)frequency.merge(key(word),1,Integer::sum);
        for(String word:words)if(frequency.get(key(word))==1)return word;
        return "";
    }
}
