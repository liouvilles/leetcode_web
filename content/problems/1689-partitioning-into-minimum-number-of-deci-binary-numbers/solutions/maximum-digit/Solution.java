class Solution { public int minPartitions(String n){int answer=0;for(char digit:n.toCharArray())answer=Math.max(answer,digit-'0');return answer;} }
