class Solution {
    public: string largestTimeFromDigits(vector<int>& arr){
        int best=-1;
        for(int i=0;i<4;++i)for(int j=0;j<4;++j)if(j!=i)for(int k=0;k<4;++k)if(k!=i&&k!=j)for(int l=0;l<4;++l)if(l!=i&&l!=j&&l!=k){
            int hour=10*arr[i]+arr[j],minute=10*arr[k]+arr[l];
            if(hour<24&&minute<60)best=max(best,hour*60+minute);
        }
        if(best<0)return "";
        char answer[6];
        snprintf(answer,sizeof(answer),"%02d:%02d",best/60,best%60);
        return answer;
    }
};
