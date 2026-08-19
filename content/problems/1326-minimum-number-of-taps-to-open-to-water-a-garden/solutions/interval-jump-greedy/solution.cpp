class Solution {
    public: int minTaps(int n,vector<int>& ranges){
        vector<int> reach(n+1);
        for(int i=0;i<=n;++i){
            int left=max(0,i-ranges[i]),right=min(n,i+ranges[i]);
            reach[left]=max(reach[left],right);
        }
        int taps=0,currentEnd=0,farthest=0;
        for(int position=0;position<n;++position){
            farthest=max(farthest,reach[position]);
            if(position==currentEnd){
                if(farthest<=position)return -1;
                ++taps;
                currentEnd=farthest;
                if(currentEnd>=n)return taps;
            }
        }
        return taps;
    }
};
