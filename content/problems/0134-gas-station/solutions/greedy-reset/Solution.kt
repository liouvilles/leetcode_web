class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var total = 0; var tank = 0; var start = 0
        for (station in gas.indices) { val balance = gas[station] - cost[station]; total += balance; tank += balance; if (tank < 0) { start = station + 1; tank = 0 } }
        return if (total >= 0) start else -1
    }
}
