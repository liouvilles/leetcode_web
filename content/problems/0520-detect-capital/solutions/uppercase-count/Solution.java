class Solution {
    public boolean detectCapitalUse(String word){
        int uppercase=0;
        for(char c:word.toCharArray())if(Character.isUpperCase(c))uppercase++;
        return uppercase==0||uppercase==word.length()||(uppercase==1&&Character.isUpperCase(word.charAt(0)));
    }
}
