class Solution {
    public: int minOperations(vector<vector<int>>& grid,int x){
        vector<int> values;
        int remainder=grid[0][0]%x;
        for(auto& row:grid)for(int value:row){
            if(value%x!=remainder)return -1;
            values.push_back(value);
        }
        nth_element(values.begin(),values.begin()+values.size()/2,values.end());
        int target=values[values.size()/2],answer=0;
        for(int value:values)answer+=abs(value-target)/x;
        return answer;
    }
};
