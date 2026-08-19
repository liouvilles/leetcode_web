class Solution {
    public:int numberOfSpecialChars(string word){
        bool lowercase[26]{
        },uppercase[26]{
        };
        for(char letter:word)if(islower((unsigned char)letter))lowercase[letter-'a']=true;
        else uppercase[letter-'A']=true;
        int answer=0;
        for(int index=0;index<26;++index)answer+=lowercase[index]&&uppercase[index];
        return answer;
    }
};
