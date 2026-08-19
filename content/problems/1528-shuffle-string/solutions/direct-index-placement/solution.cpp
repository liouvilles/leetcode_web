class Solution {
    public: string restoreString(string text,vector<int>& indices){
        string answer(text.size(),' ');
        for(int i=0;i<(int)text.size();++i)answer[indices[i]]=text[i];
        return answer;
    }
};
