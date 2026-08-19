class Solution {
    public: int numTeams(vector<int>& rating){
        int answer=0;
        for(int middle=0;middle<(int)rating.size();++middle){
            int lessLeft=0,greaterLeft=0,lessRight=0,greaterRight=0;
            for(int left=0;left<middle;++left)rating[left]<rating[middle]?++lessLeft:++greaterLeft;
            for(int right=middle+1;right<(int)rating.size();++right)rating[right]<rating[middle]?++lessRight:++greaterRight;
            answer+=lessLeft*greaterRight+greaterLeft*lessRight;
        }
        return answer;
    }
};
