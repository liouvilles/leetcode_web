class Solution { public int minimizedStringLength(String s){boolean[] seen=new boolean[26];int answer=0;for(char ch:s.toCharArray())if(!seen[ch-'a']){seen[ch-'a']=true;answer++;}return answer;} }
