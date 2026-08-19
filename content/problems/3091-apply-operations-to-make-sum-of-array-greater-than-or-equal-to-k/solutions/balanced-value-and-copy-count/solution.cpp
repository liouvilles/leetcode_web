class Solution {
    public:int minOperations(int k){
        int value=sqrt(k);
        int copies=(k+value-1)/value;
        return value+copies-2;
    }
};
