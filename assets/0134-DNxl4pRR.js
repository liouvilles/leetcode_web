const u=134,t="gas-station",n="Gas Station",g="中等",a="数组与矩阵",s=["数组","贪心"],f=!1,o="https://leetcode.cn/problems/gas-station/",k="加油站",i=["贪心","区间失败跳过","总量守恒"],c="环形路线上每站提供汽油并消耗一定油量到下一站，找出能完成一圈的唯一起点；不存在则返回 -1。",l="若从当前候选起点到某站累计油量为负，则这段区间内任何位置都不可能作为起点，可把候选直接移到下一站。",e=["总汽油小于总消耗时必无解","局部油量失败后清零重新累计","返回的是下标而不是站点数量"],r=[{id:"greedy-reset",title:"累计失败后重置起点",kind:"最优",idea:"同时维护全局净油量与当前候选区间净油量。",steps:["累加每站 gas-cost 到 total 与 tank","tank<0 时起点改为下一站并清零","total>=0 时返回候选，否则 -1"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, tank = 0, start = 0;
        for (int station = 0; station < gas.length; station++) { int balance = gas[station] - cost[station]; total += balance; tank += balance; if (tank < 0) { start = station + 1; tank = 0; } }
        return total >= 0 ? start : -1;
    }
}
`,kotlin:`class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var total = 0; var tank = 0; var start = 0
        for (station in gas.indices) { val balance = gas[station] - cost[station]; total += balance; tank += balance; if (tank < 0) { start = station + 1; tank = 0 } }
        return if (total >= 0) start else -1
    }
}
`,cpp:`class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int total = 0, tank = 0, start = 0;
        for (int station = 0; station < (int)gas.size(); ++station) { int balance = gas[station] - cost[station]; total += balance; tank += balance; if (tank < 0) { start = station + 1; tank = 0; } }
        return total >= 0 ? start : -1;
    }
};
`}}],p={id:134,slug:t,titleEn:n,difficulty:"中等",category:a,officialTags:s,paidOnly:!1,sourceUrl:o,title:"加油站",studyTags:i,summary:c,insight:l,pitfalls:e,solutions:r};export{a as category,p as default,g as difficulty,u as id,l as insight,s as officialTags,f as paidOnly,e as pitfalls,t as slug,r as solutions,o as sourceUrl,i as studyTags,c as summary,k as title,n as titleEn};
