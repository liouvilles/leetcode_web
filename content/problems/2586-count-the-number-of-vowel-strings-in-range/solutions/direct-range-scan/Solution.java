class Solution {
    public int vowelStrings(String[] words,int left,int right){
        int answer=0;
        for(int i=left;i<=right;i++){
            String word=words[i];
            if("aeiou".indexOf(word.charAt(0))>=0&&"aeiou".indexOf(word.charAt(word.length()-1))>=0)answer++;
        }
        return answer;
    }
}
