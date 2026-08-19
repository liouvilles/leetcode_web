class Solution {
    public: int findMinFibonacciNumbers(int k){
        vector<int> fib{
            1,2
        };
        while(fib.back()<k)fib.push_back(fib.back()+fib[fib.size()-2]);
        int answer=0;
        for(int i=fib.size()-1;i>=0&&k;--i)if(fib[i]<=k){
            k-=fib[i];
            ++answer;
        }
        return answer;
    }
};
