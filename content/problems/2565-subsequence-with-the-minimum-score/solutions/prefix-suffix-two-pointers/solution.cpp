class Solution {
    public:int minimumScore(string s,string t){
        int n=s.size(),m=t.size();
        vector<int> suffix(m+1);
        suffix[m]=n;
        int position=n-1;
        for(int i=m-1;i>=0;--i){
            while(position>=0&&s[position]!=t[i])--position;
            suffix[i]=position;
            --position;
        }
        int answer=m,right=0,prefixPosition=-1,searchPosition=0;
        for(int left=0;left<=m;++left){
            right=max(right,left);
            while(right<=m&&suffix[right]<=prefixPosition)++right;
            if(right<=m)answer=min(answer,right-left);
            if(left==m)break;
            while(searchPosition<n&&s[searchPosition]!=t[left])++searchPosition;
            if(searchPosition==n)break;
            prefixPosition=searchPosition++;
        }
        return answer;
    }
};
