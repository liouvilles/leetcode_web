class Solution {
    static const long long MOD=1000000007;
    vector<vector<long long>> combination;
    long long ways(vector<int> values){
        if(values.size()<=2)return 1;
        int root=values[0];
        vector<int> left,right;
        for(int i=1;i<(int)values.size();++i)(values[i]<root?left:right).push_back(values[i]);
        return combination[values.size()-1][left.size()]*ways(left)%MOD*ways(right)%MOD;
    }
    public:int numOfWays(vector<int>& nums){
        int n=nums.size();
        combination.assign(n+1,vector<long long>(n+1));
        for(int i=0;i<=n;++i){
            combination[i][0]=combination[i][i]=1;
            for(int j=1;j<i;++j)combination[i][j]=(combination[i-1][j-1]+combination[i-1][j])%MOD;
        }
        return (ways(nums)-1+MOD)%MOD;
    }
};
