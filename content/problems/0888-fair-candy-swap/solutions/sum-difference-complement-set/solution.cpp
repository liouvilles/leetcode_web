class Solution {
    public: vector<int> fairCandySwap(vector<int>& aliceSizes,vector<int>& bobSizes){
        int difference=(accumulate(aliceSizes.begin(),aliceSizes.end(),0)-accumulate(bobSizes.begin(),bobSizes.end(),0))/2;
        unordered_set<int> bob(bobSizes.begin(),bobSizes.end());
        for(int alice:aliceSizes)if(bob.count(alice-difference))return{
            alice,alice-difference
        };
        return{
        };
    }
};
