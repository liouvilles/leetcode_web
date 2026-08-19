class Solution {
    public List<String> getLongestSubsequence(String[] words,int[] groups){
        List<String> answer=new ArrayList<>();
        answer.add(words[0]);
        int lastGroup=groups[0];
        for(int i=1;i<words.length;i++)if(groups[i]!=lastGroup){
            answer.add(words[i]);
            lastGroup=groups[i];
        }
        return answer;
    }
}
