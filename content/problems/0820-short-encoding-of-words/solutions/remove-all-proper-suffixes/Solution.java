class Solution {
    public int minimumLengthEncoding(String[] words){
        Set<String> remaining=new HashSet<>(Arrays.asList(words));
        for(String word:words)for(int start=1;start<word.length();start++)remaining.remove(word.substring(start));
        int answer=0;
        for(String word:remaining)answer+=word.length()+1;
        return answer;
    }
}
