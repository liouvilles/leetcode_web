class Solution {
    public:vector<int> circularGameLosers(int n,int k){
        vector<bool> visited(n);
        int current=0,round=1;
        while(!visited[current]){
            visited[current]=true;
            current=(current+round*k)%n;
            ++round;
        }
        vector<int> answer;
        for(int i=0;i<n;++i)if(!visited[i])answer.push_back(i+1);
        return answer;
    }
};
