class Solution {
    public: string kthDistinct(vector<string>& arr,int k){
        unordered_map<string,int> frequency;
        for(string& value:arr)++frequency[value];
        for(string& value:arr)if(frequency[value]==1&&!--k)return value;
        return "";
    }
};
