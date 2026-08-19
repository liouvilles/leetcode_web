class Solution {
    fun minCost(maxTime:Int,edges:Array<IntArray>,passingFees:IntArray):Int{
        val infinity=1_000_000_000;
        val dp=Array(maxTime+1){
            IntArray(passingFees.size){
                infinity
            }
        };
        dp[0][0]=passingFees[0];
        for(time in 0..maxTime)for(edge in edges){
            val next=time+edge[2];
            if(next>maxTime)continue;
            if(dp[time][edge[0]]<infinity)dp[next][edge[1]]=minOf(dp[next][edge[1]],dp[time][edge[0]]+passingFees[edge[1]]);
            if(dp[time][edge[1]]<infinity)dp[next][edge[0]]=minOf(dp[next][edge[0]],dp[time][edge[1]]+passingFees[edge[0]])
        };
        var answer=infinity;
        for(time in 0..maxTime)answer=minOf(answer,dp[time].last());
        return if(answer==infinity)-1 else answer
    }
}
