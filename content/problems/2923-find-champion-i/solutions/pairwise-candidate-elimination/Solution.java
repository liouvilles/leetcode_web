class Solution { public int findChampion(int[][] grid){int candidate=0;for(int team=1;team<grid.length;team++)if(grid[candidate][team]==0)candidate=team;return candidate;} }
