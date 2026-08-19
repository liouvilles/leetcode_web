class Solution {
    public: int nextGreaterElement(int n){
        string digits=to_string(n);
        int pivot=digits.size()-2;
        while(pivot>=0&&digits[pivot]>=digits[pivot+1])--pivot;
        if(pivot<0)return -1;
        int successor=digits.size()-1;
        while(digits[successor]<=digits[pivot])--successor;
        swap(digits[pivot],digits[successor]);
        reverse(digits.begin()+pivot+1,digits.end());
        long long answer=stoll(digits);
        return answer>INT_MAX?-1:(int)answer;
    }
};
