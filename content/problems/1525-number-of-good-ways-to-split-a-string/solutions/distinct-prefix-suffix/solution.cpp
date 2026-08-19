class Solution {
    public: int numSplits(string text){
        int n=text.size(),count[26]={
        },distinct=0;
        vector<int> left(n),right(n);
        for(int i=0;i<n;++i){
            if(count[text[i]-'a']++==0)++distinct;
            left[i]=distinct;
        }
        fill(begin(count),end(count),0);
        distinct=0;
        for(int i=n-1;i>=0;--i){
            if(count[text[i]-'a']++==0)++distinct;
            right[i]=distinct;
        }
        int answer=0;
        for(int i=0;i<n-1;++i)answer+=left[i]==right[i+1];
        return answer;
    }
};
