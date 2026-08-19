class Solution {
    public: vector<int> numOfBurgers(int tomatoSlices,int cheeseSlices){
        int difference=tomatoSlices-2*cheeseSlices;
        if(difference<0||difference%2)return {
        };
        int jumbo=difference/2,small=cheeseSlices-jumbo;
        if(small<0)return {
        };
        return {
            jumbo,small
        };
    }
};
