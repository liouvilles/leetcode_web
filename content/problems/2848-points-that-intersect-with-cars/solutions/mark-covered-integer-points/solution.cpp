class Solution {
    public:int numberOfPoints(vector<vector<int>>& nums){
        bool covered[101]={
        };
        for(auto& interval:nums)for(int point=interval[0];point<=interval[1];++point)covered[point]=true;
        return count(begin(covered),end(covered),true);
    }
};
