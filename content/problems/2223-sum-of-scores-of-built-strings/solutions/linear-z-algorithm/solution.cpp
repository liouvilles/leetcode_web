class Solution {
    public:long long sumScores(string s){
        int n=s.size(),left=0,right=0;
        vector<int> z(n);
        long long answer=n;
        for(int i=1;i<n;++i){
            if(i<=right)z[i]=min(right-i+1,z[i-left]);
            while(i+z[i]<n&&s[z[i]]==s[i+z[i]])++z[i];
            if(i+z[i]-1>right){
                left=i;
                right=i+z[i]-1;
            }
            answer+=z[i];
        }
        return answer;
    }
};
