class Solution {
    public:int countDistinctIntegers(vector<int>& nums){
        unordered_set<int> values;
        for(int value:nums){
            values.insert(value);
            int x=value,reversed=0;
            while(x){
                reversed=reversed*10+x%10;
                x/=10;
            }
            values.insert(reversed);
        }
        return values.size();
    }
};
