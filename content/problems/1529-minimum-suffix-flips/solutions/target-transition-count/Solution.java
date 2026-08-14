class Solution { public int minFlips(String target){char current='0';int answer=0;for(char value:target.toCharArray())if(value!=current){answer++;current=value;}return answer;} }
