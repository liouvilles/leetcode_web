class Solution {
    private int value(String word){
        int result=0;
        for(char letter:word.toCharArray())result=result*10+letter-'a';
        return result;
    }
    public boolean isSumEqual(String firstWord,String secondWord,String targetWord){
        return value(firstWord)+value(secondWord)==value(targetWord);
    }
}
