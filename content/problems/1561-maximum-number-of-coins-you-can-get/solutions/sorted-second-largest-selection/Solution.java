class Solution { public int maxCoins(int[] piles){Arrays.sort(piles);int rounds=piles.length/3,answer=0;for(int index=rounds;index<piles.length;index+=2)answer+=piles[index];return answer;} }
