class Solution {
    public: int numUniqueEmails(vector<string>& emails){
        unordered_set<string> unique;
        for(string email:emails){
            int at=email.find('@'),plus=email.find('+');
            string local=email.substr(0,min(at,plus<0?at:plus)),clean;
            for(char ch:local)if(ch!='.')clean+=ch;
            unique.insert(clean+email.substr(at));
        }
        return unique.size();
    }
};
