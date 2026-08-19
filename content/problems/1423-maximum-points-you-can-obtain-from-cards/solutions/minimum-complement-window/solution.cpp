class Solution {
    public: int maxScore(vector<int>& cardPoints,int k){
        int total=accumulate(cardPoints.begin(),cardPoints.end(),0),length=cardPoints.size()-k;
        if(!length)return total;
        int window=accumulate(cardPoints.begin(),cardPoints.begin()+length,0),minimum=window;
        for(int right=length;right<(int)cardPoints.size();++right){
            window+=cardPoints[right]-cardPoints[right-length];
            minimum=min(minimum,window);
        }
        return total-minimum;
    }
};
