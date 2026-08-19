class Solution {
    unordered_set<int> distances(int boundary,vector<int>& fences){
        vector<int> positions=fences;
        positions.push_back(1);
        positions.push_back(boundary);
        unordered_set<int> result;
        for(int first=0;first<(int)positions.size();++first)for(int second=first+1;second<(int)positions.size();++second)result.insert(abs(positions[first]-positions[second]));
        return result;
    }
    public:int maximizeSquareArea(int m,int n,vector<int>& hFences,vector<int>& vFences){
        auto horizontal=distances(m,hFences),vertical=distances(n,vFences);
        long long side=-1;
        for(int distance:horizontal)if(vertical.count(distance))side=max(side,1LL*distance);
        if(side<0)return -1;
        return side*side%1000000007;
    }
};
