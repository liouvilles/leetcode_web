class Solution {
    public:vector<int> survivedRobotsHealths(vector<int>& positions,vector<int>& healths,string directions){
        vector<int> order(positions.size()),stack,answer;
        iota(order.begin(),order.end(),0);
        sort(order.begin(),order.end(),[&](int a,int b){
            return positions[a]<positions[b];
        });
        for(int robot:order){
            if(directions[robot]=='R'){
                stack.push_back(robot);
                continue;
            }while(healths[robot]>0&&!stack.empty()){
                int right=stack.back();
                if(healths[right]<healths[robot]){
                    healths[right]=0;
                    stack.pop_back();
                    --healths[robot];
                }else if(healths[right]==healths[robot]){
                    healths[right]=healths[robot]=0;
                    stack.pop_back();
                }else{
                    --healths[right];
                    healths[robot]=0;
                }
            }
        }
        for(int health:healths)if(health>0)answer.push_back(health);
        return answer;
    }
};
