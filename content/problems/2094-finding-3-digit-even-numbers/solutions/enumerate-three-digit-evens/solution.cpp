class Solution {
    public: vector<int> findEvenNumbers(vector<int>& digits){
        int available[10]={
        };
        for(int digit:digits)++available[digit];
        vector<int> answer;
        for(int number=100;number<1000;number+=2){
            int needed[10]={
            };
            for(int value=number;value;value/=10)++needed[value%10];
            bool valid=true;
            for(int digit=0;digit<10;++digit)if(needed[digit]>available[digit])valid=false;
            if(valid)answer.push_back(number);
        }
        return answer;
    }
};
