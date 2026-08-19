class Solution {
    fun findMissingAndRepeatedValues(grid:Array<IntArray>):IntArray{
        val limit=grid.size*grid.size;
        var repeated=-1;
        var missing=-1;
        val seen=BooleanArray(limit+1);
        for(row in grid)for(value in row){
            if(seen[value])repeated=value;
            seen[value]=true
        };
        for(value in 1..limit)if(!seen[value]){
            missing=value;
            break
        };
        return intArrayOf(repeated,missing)
    }
}
