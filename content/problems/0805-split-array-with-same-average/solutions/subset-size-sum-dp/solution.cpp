class Solution {
    public: bool splitArraySameAverage(vector<int>& nums){
        int n=nums.size(),total=accumulate(nums.begin(),nums.end(),0),used=0;
        vector<unordered_set<int>> sums(n/2+1);
        sums[0].insert(0);
        for(int value:nums){
            ++used;
            for(int count=min(used,n/2);count>=1;--count){
                vector<int> previous(sums[count-1].begin(),sums[count-1].end());
                for(int sum:previous)sums[count].insert(sum+value);
            }
        }
        for(int count=1;count<=n/2;++count)if(total*count%n==0&&sums[count].count(total*count/n))return true;
        return false;
    }
};
