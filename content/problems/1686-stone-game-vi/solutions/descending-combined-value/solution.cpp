class Solution {
    public: int stoneGameVI(vector<int>& aliceValues,vector<int>& bobValues){
        vector<int> order(aliceValues.size());
        iota(order.begin(),order.end(),0);
        sort(order.begin(),order.end(),[&](int a,int b){
            return aliceValues[a]+bobValues[a]>aliceValues[b]+bobValues[b];
        });
        int alice=0,bob=0;
        for(int turn=0;turn<(int)order.size();++turn)(turn%2?bob:alice)+=(turn%2?bobValues:aliceValues)[order[turn]];
        return (alice>bob)-(alice<bob);
    }
};
