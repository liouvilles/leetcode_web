class Solution {
    public: int largestAltitude(vector<int>& gain){
        int altitude=0,highest=0;
        for(int change:gain){
            altitude+=change;
            highest=max(highest,altitude);
        }
        return highest;
    }
};
