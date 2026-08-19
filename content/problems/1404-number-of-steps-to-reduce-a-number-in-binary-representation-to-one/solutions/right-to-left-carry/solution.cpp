class Solution {
    public: int numSteps(string binary){
        int steps=0,carry=0;
        for(int i=binary.size()-1;i>0;--i){
            int bit=binary[i]-'0'+carry;
            if(bit==1){
                steps+=2;
                carry=1;
            }else ++steps;
        }
        return steps+carry;
    }
};
