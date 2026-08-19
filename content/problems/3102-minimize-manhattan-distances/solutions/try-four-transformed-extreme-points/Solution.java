class Solution {
    public int minimumDistance(int[][] points){
        int minSum=Integer.MAX_VALUE,maxSum=Integer.MIN_VALUE,minDifference=Integer.MAX_VALUE,maxDifference=Integer.MIN_VALUE;
        int minSumIndex=0,maxSumIndex=0,minDifferenceIndex=0,maxDifferenceIndex=0;
        for(int index=0;index<points.length;index++){
            int sum=points[index][0]+points[index][1],difference=points[index][0]-points[index][1];
            if(sum<minSum){minSum=sum;minSumIndex=index;}if(sum>maxSum){maxSum=sum;maxSumIndex=index;}
            if(difference<minDifference){minDifference=difference;minDifferenceIndex=index;}if(difference>maxDifference){maxDifference=difference;maxDifferenceIndex=index;}
        }
        int answer=Integer.MAX_VALUE;
        int[] candidates={minSumIndex,maxSumIndex,minDifferenceIndex,maxDifferenceIndex};
        for(int removed:candidates){
            int lowSum=Integer.MAX_VALUE,highSum=Integer.MIN_VALUE,lowDifference=Integer.MAX_VALUE,highDifference=Integer.MIN_VALUE;
            for(int index=0;index<points.length;index++)if(index!=removed){
                int sum=points[index][0]+points[index][1],difference=points[index][0]-points[index][1];
                lowSum=Math.min(lowSum,sum);highSum=Math.max(highSum,sum);
                lowDifference=Math.min(lowDifference,difference);highDifference=Math.max(highDifference,difference);
            }
            answer=Math.min(answer,Math.max(highSum-lowSum,highDifference-lowDifference));
        }
        return answer;
    }
}
