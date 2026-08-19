class Solution {
    public int maximumValue(String[] strs){
        int answer=0;
        for(String word:strs){
            boolean numeric=true;
            for(char character:word.toCharArray())if(!Character.isDigit(character)){
                numeric=false;
                break;
            }
            int value=numeric?Integer.parseInt(word):word.length();
            answer=Math.max(answer,value);
        }
        return answer;
    }
}
