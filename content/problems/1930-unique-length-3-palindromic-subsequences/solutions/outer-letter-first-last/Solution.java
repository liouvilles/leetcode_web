class Solution {
    public int countPalindromicSubsequence(String s){
        int[] first=new int[26],last=new int[26];
        Arrays.fill(first,-1);
        for(int i=0;i<s.length();i++){
            int value=s.charAt(i)-'a';
            if(first[value]==-1)first[value]=i;
            last[value]=i;
        }
        int answer=0;
        for(int value=0;value<26;value++)if(first[value]+1<last[value]){
            boolean[] middle=new boolean[26];
            for(int i=first[value]+1;i<last[value];i++)middle[s.charAt(i)-'a']=true;
            for(boolean present:middle)if(present)answer++;
        }
        return answer;
    }
}
