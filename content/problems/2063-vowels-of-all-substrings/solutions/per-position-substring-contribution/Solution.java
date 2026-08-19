class Solution {
    public long countVowels(String word){
        long answer=0;
        for(int i=0;i<word.length();i++)if("aeiou".indexOf(word.charAt(i))>=0)answer+=(long)(i+1)*(word.length()-i);
        return answer;
    }
}
