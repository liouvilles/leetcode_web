class Solution {
    public int minSteps(String s,String t){
        int[] count=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        int answer=0;
        for(int value:count)if(value>0)answer+=value;
        return answer;
    }
}
