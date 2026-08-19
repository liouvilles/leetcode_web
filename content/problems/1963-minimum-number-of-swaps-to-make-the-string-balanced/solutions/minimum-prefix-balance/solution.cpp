class Solution {
    public: int minSwaps(string s){
        int balance=0,minimum=0;
        for(char value:s){
            balance+=value=='['?1:-1;
            minimum=min(minimum,balance);
        }
        return (-minimum+1)/2;
    }
};
