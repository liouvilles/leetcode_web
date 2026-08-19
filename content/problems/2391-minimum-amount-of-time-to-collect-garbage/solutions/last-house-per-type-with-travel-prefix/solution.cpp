class Solution {
    public:int garbageCollection(vector<string>& garbage,vector<int>& travel){
        vector<int> prefix(garbage.size()),last(3);
        for(int i=1;i<(int)garbage.size();++i)prefix[i]=prefix[i-1]+travel[i-1];
        int answer=0;
        string types="MPG";
        for(int i=0;i<(int)garbage.size();++i){
            answer+=garbage[i].size();
            for(char ch:garbage[i])last[types.find(ch)]=i;
        }
        for(int index:last)answer+=prefix[index];
        return answer;
    }
};
