class Solution {
    public:long long makeSubKSumEqual(vector<int>& arr,int k){
        int groups=gcd((int)arr.size(),k);
        long long answer=0;
        for(int start=0;start<groups;++start){
            vector<int> values;
            for(int index=start;index<(int)arr.size();index+=groups)values.push_back(arr[index]);
            sort(values.begin(),values.end());
            int median=values[values.size()/2];
            for(int value:values)answer+=abs((long long)value-median);
        }
        return answer;
    }
};
