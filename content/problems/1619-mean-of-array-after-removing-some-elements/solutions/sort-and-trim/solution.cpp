class Solution {
    public: double trimMean(vector<int>& arr){
        sort(arr.begin(),arr.end());
        int trim=arr.size()/20;
        double sum=accumulate(arr.begin()+trim,arr.end()-trim,0.0);
        return sum/(arr.size()-2*trim);
    }
};
