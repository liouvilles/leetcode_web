class Solution {
    string mergeStrings(string first,string second){
        if(first.find(second)!=string::npos)return first;
        if(second.find(first)!=string::npos)return second;
        for(int overlap=min(first.size(),second.size());overlap>=0;--overlap)if(first.substr(first.size()-overlap)==second.substr(0,overlap))return first+second.substr(overlap);
        return first+second;
    }
    public:string minimumString(string a,string b,string c){
        vector<string> values={
            a,b,c
        };
        int orders[6][3]={
            {
                0,1,2
            },{
                0,2,1
            },{
                1,0,2
            },{
                1,2,0
            },{
                2,0,1
            },{
                2,1,0
            }
        };
        string best;
        for(auto& order:orders){
            string candidate=mergeStrings(mergeStrings(values[order[0]],values[order[1]]),values[order[2]]);
            if(best.empty()||candidate.size()<best.size()||candidate.size()==best.size()&&candidate<best)best=candidate;
        }
        return best;
    }
};
