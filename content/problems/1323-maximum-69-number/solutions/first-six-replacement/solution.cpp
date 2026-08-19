class Solution {
    public: int maximum69Number(int num){
        string digits=to_string(num);
        for(char& digit:digits)if(digit=='6'){
            digit='9';
            break;
        }
        return stoi(digits);
    }
};
