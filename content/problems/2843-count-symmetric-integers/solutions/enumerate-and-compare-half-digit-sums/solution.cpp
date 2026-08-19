class Solution {
    public:int countSymmetricIntegers(int low,int high){
        int answer=0;
        for(int value=low;value<=high;++value){
            string digits=to_string(value);
            if(digits.size()%2)continue;
            int first=0,second=0,half=digits.size()/2;
            for(int i=0;i<half;++i){
                first+=digits[i]-'0';
                second+=digits[i+half]-'0';
            }
            if(first==second)++answer;
        }
        return answer;
    }
};
