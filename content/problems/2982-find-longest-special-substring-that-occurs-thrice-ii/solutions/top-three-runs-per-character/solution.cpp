class Solution {
    void add(array<array<int,3>,26>& longest,int letter,int length){
        if(length>longest[letter][0]){
            longest[letter][2]=longest[letter][1];
            longest[letter][1]=longest[letter][0];
            longest[letter][0]=length;
        }else if(length>longest[letter][1]){
            longest[letter][2]=longest[letter][1];
            longest[letter][1]=length;
        }else if(length>longest[letter][2])longest[letter][2]=length;
    }
    public:int maximumLength(string s){
        array<array<int,3>,26> longest{
        };
        for(int start=0;start<(int)s.size();){
            int end=start+1;
            while(end<(int)s.size()&&s[end]==s[start])++end;
            add(longest,s[start]-'a',end-start);
            start=end;
        }
        int answer=0;
        for(auto runs:longest)answer=max({
            answer,runs[0]-2,min(runs[0]-1,runs[1]),runs[2]
        });
        return answer>0?answer:-1;
    }
};
