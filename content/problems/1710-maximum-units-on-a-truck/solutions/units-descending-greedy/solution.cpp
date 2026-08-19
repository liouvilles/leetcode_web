class Solution {
    public: int maximumUnits(vector<vector<int>>& boxTypes,int truckSize){
        sort(boxTypes.begin(),boxTypes.end(),[](auto& a,auto& b){
            return a[1]>b[1];
        });
        int answer=0;
        for(auto& type:boxTypes){
            int take=min(type[0],truckSize);
            answer+=take*type[1];
            truckSize-=take;
            if(!truckSize)break;
        }
        return answer;
    }
};
