class Solution {
    int gap(int length,vector<int>& cuts){
        sort(cuts.begin(),cuts.end());
        int previous=0,maximum=0;
        for(int cut:cuts){
            maximum=max(maximum,cut-previous);
            previous=cut;
        }
        return max(maximum,length-previous);
    }
    public:int maxArea(int h,int w,vector<int>& horizontalCuts,vector<int>& verticalCuts){
        return 1LL*gap(h,horizontalCuts)*gap(w,verticalCuts)%1000000007;
    }
};
