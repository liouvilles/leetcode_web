class Solution {
    public: double average(vector<int>& salary){
        int sum=accumulate(salary.begin(),salary.end(),0),minimum=*min_element(salary.begin(),salary.end()),maximum=*max_element(salary.begin(),salary.end());
        return (double)(sum-minimum-maximum)/(salary.size()-2);
    }
};
