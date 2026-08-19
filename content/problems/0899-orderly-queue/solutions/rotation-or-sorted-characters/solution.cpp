class Solution {
    public: string orderlyQueue(string s,int k){
        if(k>1){
            sort(s.begin(),s.end());
            return s;
        }
        string best=s;
        for(int shift=1;shift<(int)s.size();++shift){
            string candidate=s.substr(shift)+s.substr(0,shift);
            best=min(best,candidate);
        }
        return best;
    }
};
