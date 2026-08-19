class Solution {
    public String toGoatLatin(String sentence){
        Set<Character> vowels=new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        String[] words=sentence.split(" ");
        StringBuilder answer=new StringBuilder();
        for(int i=0;i<words.length;i++){
            if(i>0)answer.append(' ');
            String word=words[i];
            if(!vowels.contains(word.charAt(0)))word=word.substring(1)+word.charAt(0);
            answer.append(word).append("ma");
            for(int count=0;count<=i;count++)answer.append('a');
        }
        return answer.toString();
    }
}
