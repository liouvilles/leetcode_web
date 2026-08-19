class Solution {
    public int maximumNumberOfStringPairs(String[] words){
        Set<String> seen=new HashSet<>();
        int answer=0;
        for(String word:words){
            String reversed=""+word.charAt(1)+word.charAt(0);
            if(seen.contains(reversed))answer++;
            else seen.add(word);
        }
        return answer;
    }
}
