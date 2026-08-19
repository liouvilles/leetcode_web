class Solution {
    public: int videoStitching(vector<vector<int>>& clips,int time){
        sort(clips.begin(),clips.end());
        int index=0,currentEnd=0,used=0;
        while(currentEnd<time){
            int farthest=currentEnd;
            while(index<(int)clips.size()&&clips[index][0]<=currentEnd)farthest=max(farthest,clips[index++][1]);
            if(farthest==currentEnd)return -1;
            currentEnd=farthest;
            ++used;
        }
        return used;
    }
};
