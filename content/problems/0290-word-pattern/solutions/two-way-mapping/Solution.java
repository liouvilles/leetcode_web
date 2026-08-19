class Solution {
    public boolean wordPattern(String pattern,String s){
        String[] words=s.split(" ");
        if(pattern.length()!=words.length)return false;
        Map<Character,String> forward=new HashMap<>();
        Map<String,Character> reverse=new HashMap<>();
        for(int i=0;i<words.length;i++){
            char c=pattern.charAt(i);
            if(forward.containsKey(c)&&!forward.get(c).equals(words[i]))return false;
            if(reverse.containsKey(words[i])&&reverse.get(words[i])!=c)return false;
            forward.put(c,words[i]);
            reverse.put(words[i],c);
        }
        return true;
    }
}
