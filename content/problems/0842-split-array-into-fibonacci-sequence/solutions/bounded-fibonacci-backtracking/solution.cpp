class Solution {
    bool dfs(string& num,int index,vector<int>& sequence){
        if(index==(int)num.size())return sequence.size()>=3;
        long long value=0;
        for(int end=index;end<(int)num.size();++end){
            if(end>index&&num[index]=='0')break;
            value=value*10+num[end]-'0';
            if(value>INT_MAX)break;
            if(sequence.size()>=2){
                long long sum=(long long)sequence[sequence.size()-1]+sequence[sequence.size()-2];
                if(value<sum)continue;
                if(value>sum)break;
            }
            sequence.push_back(value);
            if(dfs(num,end+1,sequence))return true;
            sequence.pop_back();
        }
        return false;
    }
    public:vector<int> splitIntoFibonacci(string num){
        vector<int> sequence;
        dfs(num,0,sequence);
        return sequence;
    }
};
