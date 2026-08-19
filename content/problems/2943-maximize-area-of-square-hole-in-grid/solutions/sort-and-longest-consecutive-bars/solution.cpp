class Solution {
    int longestSpan(vector<int>& bars){
        sort(bars.begin(),bars.end());
        int best=1,current=1;
        for(int i=1;i<(int)bars.size();++i){
            current=bars[i]==bars[i-1]+1?current+1:1;
            best=max(best,current);
        }
        return best+1;
    }
    public:int maximizeSquareHoleArea(int n,int m,vector<int>& hBars,vector<int>& vBars){
        int side=min(longestSpan(hBars),longestSpan(vBars));
        return side*side;
    }
};
