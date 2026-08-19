class Solution {
    public String[] findWords(String[] words){
        int[] row=new int[26];
        for(char c:"qwertyuiop".toCharArray())row[c-'a']=1;
        for(char c:"asdfghjkl".toCharArray())row[c-'a']=2;
        for(char c:"zxcvbnm".toCharArray())row[c-'a']=3;
        List<String> answer=new ArrayList<>();
        for(String word:words){
            int target=row[Character.toLowerCase(word.charAt(0))-'a'];
            boolean valid=true;
            for(char c:word.toCharArray())if(row[Character.toLowerCase(c)-'a']!=target){
                valid=false;
                break;
            }
            if(valid)answer.add(word);
        }
        return answer.toArray(new String[0]);
    }
}
