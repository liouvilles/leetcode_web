class Solution {
    public String largestMerge(String word1,String word2){
        StringBuilder answer=new StringBuilder();
        int first=0,second=0;
        while(first<word1.length()&&second<word2.length())if(word1.substring(first).compareTo(word2.substring(second))>0)answer.append(word1.charAt(first++));
        else answer.append(word2.charAt(second++));
        return answer.append(word1.substring(first)).append(word2.substring(second)).toString();
    }
}
