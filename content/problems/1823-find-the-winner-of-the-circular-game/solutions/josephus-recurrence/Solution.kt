class Solution { fun findTheWinner(n:Int,k:Int):Int{var winner=0;for(size in 1..n)winner=(winner+k)%size;return winner+1} }
