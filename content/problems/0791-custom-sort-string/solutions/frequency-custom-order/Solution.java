class Solution {
    public String customSortString(String order,String s){
        int[] frequency=new int[26];
        for(char c:s.toCharArray())frequency[c-'a']++;
        StringBuilder answer=new StringBuilder();
        for(char c:order.toCharArray())while(frequency[c-'a']>0){
            answer.append(c);
            frequency[c-'a']--;
        }
        for(int i=0;i<26;i++)while(frequency[i]>0){
            answer.append((char)('a'+i));
            frequency[i]--;
        }
        return answer.toString();
    }
}
