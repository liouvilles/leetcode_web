class Solution {
    public: bool isNStraightHand(vector<int>& hand,int groupSize){
        if(hand.size()%groupSize)return false;
        map<int,int> count;
        for(int value:hand)++count[value];
        while(!count.empty()){
            int start=count.begin()->first;
            for(int value=start;value<start+groupSize;++value){
                auto found=count.find(value);
                if(found==count.end())return false;
                if(--found->second==0)count.erase(found);
            }
        }
        return true;
    }
};
