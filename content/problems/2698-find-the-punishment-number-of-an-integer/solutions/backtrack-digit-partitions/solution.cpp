class Solution {
    bool canSplit(string& digits,int index,int sum,int target){
        if(index==(int)digits.size())return sum==target;
        int number=0;
        for(int end=index;end<(int)digits.size();++end){
            number=number*10+digits[end]-'0';
            if(sum+number>target)break;
            if(canSplit(digits,end+1,sum+number,target))return true;
        }
        return false;
    }
    public:int punishmentNumber(int n){
        int answer=0;
        for(int value=1;value<=n;++value){
            int square=value*value;
            string digits=to_string(square);
            if(canSplit(digits,0,0,value))answer+=square;
        }
        return answer;
    }
};
