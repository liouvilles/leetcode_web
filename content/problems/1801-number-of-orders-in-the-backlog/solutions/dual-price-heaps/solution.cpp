class Solution {
    public: int getNumberOfBacklogOrders(vector<vector<int>>& orders){
        priority_queue<pair<int,int>> buy;
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> sell;
        for(auto order:orders){
            int price=order[0],amount=order[1];
            if(!order[2]){
                while(amount&&!sell.empty()&&sell.top().first<=price){
                    auto [otherPrice,otherAmount]=sell.top();
                    sell.pop();
                    int traded=min(amount,otherAmount);
                    amount-=traded;
                    otherAmount-=traded;
                    if(otherAmount)sell.push({
                        otherPrice,otherAmount
                    });
                }
                if(amount)buy.push({
                    price,amount
                });
            }else{
                while(amount&&!buy.empty()&&buy.top().first>=price){
                    auto [otherPrice,otherAmount]=buy.top();
                    buy.pop();
                    int traded=min(amount,otherAmount);
                    amount-=traded;
                    otherAmount-=traded;
                    if(otherAmount)buy.push({
                        otherPrice,otherAmount
                    });
                }
                if(amount)sell.push({
                    price,amount
                });
            }
        }
        long long total=0;
        while(!buy.empty()){
            total+=buy.top().second;
            buy.pop();
        }while(!sell.empty()){
            total+=sell.top().second;
            sell.pop();
        }
        return total%1000000007;
    }
};
