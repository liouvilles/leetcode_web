class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, tank = 0, start = 0;
        for (int station = 0; station < gas.length; station++) { int balance = gas[station] - cost[station]; total += balance; tank += balance; if (tank < 0) { start = station + 1; tank = 0; } }
        return total >= 0 ? start : -1;
    }
}
