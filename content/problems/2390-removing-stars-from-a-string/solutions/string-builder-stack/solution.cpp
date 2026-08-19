class Solution {
    public:string removeStars(string s){
        string answer;
        for(char ch:s)if(ch=='*')answer.pop_back();
        else answer+=ch;
        return answer;
    }
};
