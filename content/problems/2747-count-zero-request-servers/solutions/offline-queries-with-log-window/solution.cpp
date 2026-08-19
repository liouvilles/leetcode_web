class Solution {
    public:vector<int> countServers(int n,vector<vector<int>>& logs,int x,vector<int>& queries){
        sort(logs.begin(),logs.end(),[](auto& a,auto& b){
            return a[1]<b[1];
        });
        vector<int> order(queries.size()),frequency(n+1),answer(queries.size());
        iota(order.begin(),order.end(),0);
        sort(order.begin(),order.end(),[&](int a,int b){
            return queries[a]<queries[b];
        });
        int left=0,right=0,active=0;
        for(int queryIndex:order){
            int query=queries[queryIndex];
            while(right<(int)logs.size()&&logs[right][1]<=query){
                int server=logs[right++][0];
                if(frequency[server]++==0)++active;
            }while(left<right&&logs[left][1]<query-x){
                int server=logs[left++][0];
                if(--frequency[server]==0)--active;
            }
            answer[queryIndex]=n-active;
        }
        return answer;
    }
};
