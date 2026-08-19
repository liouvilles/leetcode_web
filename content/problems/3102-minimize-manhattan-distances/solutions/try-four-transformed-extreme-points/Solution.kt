class Solution {
    fun minimumDistance(points:Array<IntArray>):Int{
        var minSum=Int.MAX_VALUE;var maxSum=Int.MIN_VALUE;var minDifference=Int.MAX_VALUE;var maxDifference=Int.MIN_VALUE
        var minSumIndex=0;var maxSumIndex=0;var minDifferenceIndex=0;var maxDifferenceIndex=0
        for(index in points.indices){
            val sum=points[index][0]+points[index][1];val difference=points[index][0]-points[index][1]
            if(sum<minSum){minSum=sum;minSumIndex=index};if(sum>maxSum){maxSum=sum;maxSumIndex=index}
            if(difference<minDifference){minDifference=difference;minDifferenceIndex=index};if(difference>maxDifference){maxDifference=difference;maxDifferenceIndex=index}
        }
        var answer=Int.MAX_VALUE
        for(removed in intArrayOf(minSumIndex,maxSumIndex,minDifferenceIndex,maxDifferenceIndex)){
            var lowSum=Int.MAX_VALUE;var highSum=Int.MIN_VALUE;var lowDifference=Int.MAX_VALUE;var highDifference=Int.MIN_VALUE
            for(index in points.indices)if(index!=removed){
                val sum=points[index][0]+points[index][1];val difference=points[index][0]-points[index][1]
                lowSum=minOf(lowSum,sum);highSum=maxOf(highSum,sum);lowDifference=minOf(lowDifference,difference);highDifference=maxOf(highDifference,difference)
            }
            answer=minOf(answer,maxOf(highSum-lowSum,highDifference-lowDifference))
        }
        return answer
    }
}
