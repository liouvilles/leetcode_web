class Solution {
    public: vector<int> lexicalOrder(int n){
        vector<int> answer;
        answer.reserve(n);
        int current=1;
        for(int count=0;count<n;++count){
            answer.push_back(current);
            if((long long)current*10<=n)current*=10;
            else{
                while(current%10==9||current+1>n)current/=10;
                ++current;
            }
        }
        return answer;
    }
};
