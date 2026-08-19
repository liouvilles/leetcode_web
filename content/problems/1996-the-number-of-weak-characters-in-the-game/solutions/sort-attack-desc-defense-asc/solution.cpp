class Solution {
    public: int numberOfWeakCharacters(vector<vector<int>>& properties){
        sort(properties.begin(),properties.end(),[](auto& a,auto& b){
            return a[0]!=b[0]?a[0]>b[0]:a[1]<b[1];
        });
        int answer=0,maximum=0;
        for(auto& property:properties){
            answer+=property[1]<maximum;
            maximum=max(maximum,property[1]);
        }
        return answer;
    }
};
