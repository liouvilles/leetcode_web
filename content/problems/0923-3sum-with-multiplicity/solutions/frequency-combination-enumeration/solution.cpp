class Solution {
    public: int threeSumMulti(vector<int>& arr,int target){
        const long long mod=1000000007;
        long long answer=0,count[101]={
        };
        for(int value:arr)++count[value];
        for(int a=0;a<=100;++a)for(int b=a;b<=100;++b){
            int c=target-a-b;
            if(c<b||c>100)continue;
            long long ways;
            if(a==b&&b==c)ways=count[a]*(count[a]-1)*(count[a]-2)/6;
            else if(a==b)ways=count[a]*(count[a]-1)/2*count[c];
            else if(b==c)ways=count[a]*count[b]*(count[b]-1)/2;
            else ways=count[a]*count[b]*count[c];
            answer=(answer+ways)%mod;
        }
        return answer;
    }
};
