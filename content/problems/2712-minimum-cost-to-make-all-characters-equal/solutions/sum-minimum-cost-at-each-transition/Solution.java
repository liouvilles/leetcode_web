class Solution { public long minimumCost(String s){long answer=0;for(int i=1;i<s.length();i++)if(s.charAt(i)!=s.charAt(i-1))answer+=Math.min(i,s.length()-i);return answer;} }
