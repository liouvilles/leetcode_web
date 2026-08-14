class Solution { public int numTimesAllBlue(int[] flips){int maximum=0,answer=0;for(int i=0;i<flips.length;i++){maximum=Math.max(maximum,flips[i]);if(maximum==i+1)answer++;}return answer;} }
