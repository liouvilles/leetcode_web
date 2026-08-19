class Solution {
    public: int nthUglyNumber(int n){
        vector<int> ugly(n);
        ugly[0]=1;
        int p2=0,p3=0,p5=0;
        for(int i=1;i<n;++i){
            int next=min({
                ugly[p2]*2,ugly[p3]*3,ugly[p5]*5
            });
            ugly[i]=next;
            if(next==ugly[p2]*2)++p2;
            if(next==ugly[p3]*3)++p3;
            if(next==ugly[p5]*5)++p5;
        }
        return ugly.back();
    }
};
