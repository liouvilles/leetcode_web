class Solution {
    public:int largestInteger(int num){
        string digits=to_string(num),odd,even;
        for(char digit:digits)(digit%2?odd:even)+=digit;
        sort(odd.rbegin(),odd.rend());
        sort(even.rbegin(),even.rend());
        int o=0,e=0;
        for(char& digit:digits)digit=digit%2?odd[o++]:even[e++];
        return stoi(digits);
    }
};
