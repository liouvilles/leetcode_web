class Solution {
    public: string pushDominoes(string dominoes){
        int n=dominoes.size(),force=0;
        vector<int> forces(n);
        for(int i=0;i<n;++i){
            force=dominoes[i]=='R'?n:dominoes[i]=='L'?0:max(force-1,0);
            forces[i]+=force;
        }
        force=0;
        for(int i=n-1;i>=0;--i){
            force=dominoes[i]=='L'?n:dominoes[i]=='R'?0:max(force-1,0);
            forces[i]-=force;
        }
        string answer;
        for(int value:forces)answer+=value>0?'R':value<0?'L':'.';
        return answer;
    }
};
