class Solution {
    public:int divisorSubstrings(int num,int k){
        string text=to_string(num);
        int answer=0;
        for(int i=0;i+k<=(int)text.size();++i){
            int value=stoi(text.substr(i,k));
            if(value&&num%value==0)++answer;
        }
        return answer;
    }
};
