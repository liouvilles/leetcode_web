class Solution {
    bool canErase(string& text,string& stamp,int start){
        bool fresh=false;
        for(int i=0;i<(int)stamp.size();++i)if(text[start+i]!='*'){
            if(text[start+i]!=stamp[i])return false;
            fresh=true;
        }
        return fresh;
    }
    int erase(string& text,int start,int length){
        int count=0;
        for(int i=0;i<length;++i)if(text[start+i]!='*'){
            text[start+i]='*';
            ++count;
        }
        return count;
    }
    public:vector<int> movesToStamp(string stamp,string target){
        vector<bool> done(target.size()-stamp.size()+1);
        vector<int> moves;
        int erased=0;
        while(erased<(int)target.size()){
            bool changed=false;
            for(int start=0;start<(int)done.size();++start)if(!done[start]&&canErase(target,stamp,start)){
                int added=erase(target,start,stamp.size());
                if(added){
                    erased+=added;
                    changed=true;
                    done[start]=true;
                    moves.push_back(start);
                }
            }
            if(!changed)return {
            };
        }
        reverse(moves.begin(),moves.end());
        return moves;
    }
};
