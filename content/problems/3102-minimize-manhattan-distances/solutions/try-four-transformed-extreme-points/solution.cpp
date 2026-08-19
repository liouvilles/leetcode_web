class Solution {
public:
    int minimumDistance(vector<vector<int>>& points){
        int minSum=INT_MAX,maxSum=INT_MIN,minDifference=INT_MAX,maxDifference=INT_MIN;
        int minSumIndex=0,maxSumIndex=0,minDifferenceIndex=0,maxDifferenceIndex=0;
        for(int index=0;index<(int)points.size();++index){
            int sum=points[index][0]+points[index][1],difference=points[index][0]-points[index][1];
            if(sum<minSum){minSum=sum;minSumIndex=index;}if(sum>maxSum){maxSum=sum;maxSumIndex=index;}
            if(difference<minDifference){minDifference=difference;minDifferenceIndex=index;}if(difference>maxDifference){maxDifference=difference;maxDifferenceIndex=index;}
        }
        int answer=INT_MAX;
        for(int removed:{minSumIndex,maxSumIndex,minDifferenceIndex,maxDifferenceIndex}){
            int lowSum=INT_MAX,highSum=INT_MIN,lowDifference=INT_MAX,highDifference=INT_MIN;
            for(int index=0;index<(int)points.size();++index)if(index!=removed){
                int sum=points[index][0]+points[index][1],difference=points[index][0]-points[index][1];
                lowSum=min(lowSum,sum);highSum=max(highSum,sum);lowDifference=min(lowDifference,difference);highDifference=max(highDifference,difference);
            }
            answer=min(answer,max(highSum-lowSum,highDifference-lowDifference));
        }
        return answer;
    }
};
