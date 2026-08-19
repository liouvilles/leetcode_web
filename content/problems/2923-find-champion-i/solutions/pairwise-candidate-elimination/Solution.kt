class Solution {
    fun findChampion(grid:Array<IntArray>):Int{
        var candidate=0;
        for(team in 1 until grid.size)if(grid[candidate][team]==0)candidate=team;
        return candidate
    }
}
