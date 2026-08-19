class Solution {
    void dfs(string& s,int index,vector<string>& answer){
        if(index==(int)s.size()){
            answer.push_back(s);
            return;
        }
        if(isalpha(s[index])){
            s[index]=tolower(s[index]);
            dfs(s,index+1,answer);
            s[index]=toupper(s[index]);
            dfs(s,index+1,answer);
        }else dfs(s,index+1,answer);
    }
    public:vector<string> letterCasePermutation(string s){
        vector<string> answer;
        dfs(s,0,answer);
        return answer;
    }
};
