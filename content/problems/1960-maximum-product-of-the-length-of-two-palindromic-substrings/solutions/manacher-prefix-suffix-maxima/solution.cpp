class Solution {
    public: long long maxProduct(string s){
        int n=s.size();
        vector<int> radius(n);
        for(int i=0,left=0,right=-1;i<n;++i){
            int value=i>right?1:min(radius[left+right-i],right-i+1);
            while(i-value>=0&&i+value<n&&s[i-value]==s[i+value])++value;
            radius[i]=value;
            if(i+value-1>right){
                left=i-value+1;
                right=i+value-1;
            }
        }
        vector<int> ending(n),starting(n);
        for(int i=0;i<n;++i){
            int length=2*radius[i]-1;
            ending[i+radius[i]-1]=max(ending[i+radius[i]-1],length);
            starting[i-radius[i]+1]=max(starting[i-radius[i]+1],length);
        }
        for(int i=n-2;i>=0;--i)ending[i]=max(ending[i],ending[i+1]-2);
        for(int i=1;i<n;++i)ending[i]=max(ending[i],ending[i-1]);
        for(int i=1;i<n;++i)starting[i]=max(starting[i],starting[i-1]-2);
        for(int i=n-2;i>=0;--i)starting[i]=max(starting[i],starting[i+1]);
        long long answer=0;
        for(int i=0;i+1<n;++i)answer=max(answer,1LL*ending[i]*starting[i+1]);
        return answer;
    }
};
