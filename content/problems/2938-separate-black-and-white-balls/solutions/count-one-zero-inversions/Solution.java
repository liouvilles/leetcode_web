class Solution { public long minimumSteps(String s){long ones=0,answer=0;for(char ball:s.toCharArray())if(ball=='1')ones++;else answer+=ones;return answer;} }
