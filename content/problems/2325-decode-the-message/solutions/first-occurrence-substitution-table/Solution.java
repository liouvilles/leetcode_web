class Solution {
    public String decodeMessage(String key,String message){
        char[] mapping=new char[26];
        char next='a';
        for(char ch:key.toCharArray())if(ch!=' '&&mapping[ch-'a']==0)mapping[ch-'a']=next++;
        StringBuilder answer=new StringBuilder();
        for(char ch:message.toCharArray())answer.append(ch==' '?ch:mapping[ch-'a']);
        return answer.toString();
    }
}
