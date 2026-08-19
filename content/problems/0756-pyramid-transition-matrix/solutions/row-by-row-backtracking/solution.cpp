class Solution {
    unordered_map<string,vector<char>> choices;
    bool solve(string row){
        if(row.size()==1)return true;
        string next;
        return build(row,0,next);
    }
    bool build(string& row,int position,string& next){
        if(position==(int)row.size()-1)return solve(next);
        auto it=choices.find(row.substr(position,2));
        if(it==choices.end())return false;
        for(char c:it->second){
            next+=c;
            if(build(row,position+1,next))return true;
            next.pop_back();
        }
        return false;
    }
    public:bool pyramidTransition(string bottom,vector<string>& allowed){
        for(string& rule:allowed)choices[rule.substr(0,2)].push_back(rule[2]);
        return solve(bottom);
    }
};
