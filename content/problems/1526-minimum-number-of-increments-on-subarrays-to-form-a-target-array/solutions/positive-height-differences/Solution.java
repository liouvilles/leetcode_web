class Solution { public int minNumberOperations(int[] target){int answer=target[0];for(int i=1;i<target.length;i++)answer+=Math.max(0,target[i]-target[i-1]);return answer;} }
