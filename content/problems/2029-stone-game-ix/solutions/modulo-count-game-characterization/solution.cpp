class Solution {
    public: bool stoneGameIX(vector<int>& stones){
        int count[3]={
        };
        for(int stone:stones)++count[stone%3];
        return count[0]%2==0?count[1]&&count[2]:abs(count[1]-count[2])>2;
    }
};
