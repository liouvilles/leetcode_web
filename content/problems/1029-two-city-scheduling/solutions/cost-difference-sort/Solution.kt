class Solution {
    fun twoCitySchedCost(costs:Array<IntArray>):Int{
        costs.sortBy{
            it[0]-it[1]
        };
        val n=costs.size/2;
        return costs.indices.sumOf{
            if(it<n)costs[it][0] else costs[it][1]
        }
    }
}
