class Solution {
    public: vector<int> pathInZigZagTree(int label){
        vector<int> path;
        int level=31-__builtin_clz(label);
        while(label>=1){
            path.push_back(label);
            int start=1<<level,end=(1<<(level+1))-1;
            label=(start+end-label)/2;
            --level;
        }
        reverse(path.begin(),path.end());
        return path;
    }
};
