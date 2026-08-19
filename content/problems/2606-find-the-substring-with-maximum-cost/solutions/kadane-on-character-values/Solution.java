class Solution {
    public int maximumCostSubstring(String s,String chars,int[] vals){
        int[] value=new int[26];
        for(int i=0;i<26;i++)value[i]=i+1;
        for(int i=0;i<chars.length();i++)value[chars.charAt(i)-'a']=vals[i];
        int current=0,answer=0;
        for(char letter:s.toCharArray()){
            current=Math.max(0,current+value[letter-'a']);
            answer=Math.max(answer,current);
        }
        return answer;
    }
}
