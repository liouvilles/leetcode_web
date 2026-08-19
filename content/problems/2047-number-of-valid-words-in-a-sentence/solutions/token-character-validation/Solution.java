class Solution {
    private boolean valid(String token){
        int hyphens=0,punctuation=0;
        for(int i=0;i<token.length();i++){
            char value=token.charAt(i);
            if(Character.isDigit(value))return false;
            if(value=='-'){
                if(++hyphens>1||i==0||i==token.length()-1||!Character.isLowerCase(token.charAt(i-1))||!Character.isLowerCase(token.charAt(i+1)))return false;
            }else if(value=='!'||value=='.'||value==','){
                if(++punctuation>1||i!=token.length()-1)return false;
            }else if(!Character.isLowerCase(value))return false;
        }
        return true;
    }
    public int countValidWords(String sentence){
        int answer=0;
        for(String token:sentence.trim().split("\\s+"))if(valid(token))answer++;
        return answer;
    }
}
