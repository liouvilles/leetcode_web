class Solution { fun minCostToMoveChips(position:IntArray):Int{var even=0;var odd=0;for(value in position)if(value%2==0)even++ else odd++;return minOf(even,odd)} }
