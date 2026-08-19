class Solution {
    public int longestValidSubstring(String word,List<String> forbidden){
        Set<String> banned=new HashSet<>(forbidden);
        int left=0,answer=0;
        for(int right=0;right<word.length();right++){
            for(int start=right;start>=Math.max(left,right-9);start--)if(banned.contains(word.substring(start,right+1))){
                left=start+1;
                break;
            }
            answer=Math.max(answer,right-left+1);
        }
        return answer;
    }
}
