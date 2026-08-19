class Solution {
    bool valid(string token){
        int hyphens=0,punctuation=0;
        for(int i=0;i<(int)token.size();++i){
            char value=token[i];
            if(isdigit(value))return false;
            if(value=='-'){
                if(++hyphens>1||!i||i+1==(int)token.size()||!islower(token[i-1])||!islower(token[i+1]))return false;
            }else if(value=='!'||value=='.'||value==','){
                if(++punctuation>1||i+1!=(int)token.size())return false;
            }else if(!islower(value))return false;
        }
        return true;
    }
    public: int countValidWords(string sentence){
        stringstream stream(sentence);
        string token;
        int answer=0;
        while(stream>>token)answer+=valid(token);
        return answer;
    }
};
