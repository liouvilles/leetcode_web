class Solution {
    string text;
    int answer=0;
    void dfs(int index,unordered_set<string>& used){
        if(index==(int)text.size()){
            answer=max(answer,(int)used.size());
            return;
        }
        if((int)used.size()+(int)text.size()-index<=answer)return;
        for(int end=index+1;end<=(int)text.size();++end){
            string part=text.substr(index,end-index);
            if(used.insert(part).second){
                dfs(end,used);
                used.erase(part);
            }
        }
    }
    public:int maxUniqueSplit(string s){
        text=s;
        unordered_set<string> used;
        dfs(0,used);
        return answer;
    }
};
