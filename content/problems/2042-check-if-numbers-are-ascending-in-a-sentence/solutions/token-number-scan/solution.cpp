class Solution {
    public: bool areNumbersAscending(string s){
        stringstream stream(s);
        string token;
        int previous=-1;
        while(stream>>token)if(isdigit(token[0])){
            int current=stoi(token);
            if(current<=previous)return false;
            previous=current;
        }
        return true;
    }
};
