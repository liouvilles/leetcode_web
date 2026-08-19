class Solution {
    public:vector<string> cellsInRange(string s){
        vector<string> answer;
        for(char column=s[0];column<=s[3];++column)for(char row=s[1];row<=s[4];++row)answer.push_back(string()+column+row);
        return answer;
    }
};
