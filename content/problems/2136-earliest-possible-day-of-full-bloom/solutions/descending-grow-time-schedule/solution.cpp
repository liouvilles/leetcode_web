class Solution {
    public:int earliestFullBloom(vector<int>& plantTime,vector<int>& growTime){
        vector<int> order(plantTime.size());
        iota(order.begin(),order.end(),0);
        sort(order.begin(),order.end(),[&](int a,int b){
            return growTime[a]>growTime[b];
        });
        int elapsed=0,answer=0;
        for(int index:order){
            elapsed+=plantTime[index];
            answer=max(answer,elapsed+growTime[index]);
        }
        return answer;
    }
};
