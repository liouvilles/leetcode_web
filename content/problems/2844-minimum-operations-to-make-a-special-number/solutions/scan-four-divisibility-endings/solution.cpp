class Solution {
    public:int minimumOperations(string num){
        int n=num.size(),answer=num.find('0')!=string::npos?n-1:n;
        for(string ending:vector<string>{
            "00","25","50","75"
        }){
            int second=-1;
            for(int i=n-1;i>=0;--i)if(num[i]==ending[1]){
                second=i;
                break;
            }
            if(second<0)continue;
            for(int first=second-1;first>=0;--first)if(num[first]==ending[0]){
                answer=min(answer,n-first-2);
                break;
            }
        }
        return answer;
    }
};
