class Solution { public int secondsToRemoveOccurrences(String s){int zeros=0,answer=0;for(char ch:s.toCharArray())if(ch=='0')zeros++;else if(zeros>0)answer=Math.max(zeros,answer+1);return answer;} }
