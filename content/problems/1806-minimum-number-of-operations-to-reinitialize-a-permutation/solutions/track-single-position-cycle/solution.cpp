class Solution {
    public: int reinitializePermutation(int n){
        int position=1,operations=0;
        do{
            position=position%2? n/2+(position-1)/2:position/2;
            ++operations;
        }while(position!=1);
        return operations;
    }
};
