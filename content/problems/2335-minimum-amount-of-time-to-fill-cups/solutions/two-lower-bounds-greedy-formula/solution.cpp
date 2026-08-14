class Solution { public:int fillCups(vector<int>& amount){int sum=accumulate(amount.begin(),amount.end(),0),maximum=*max_element(amount.begin(),amount.end());return max(maximum,(sum+1)/2);} };
