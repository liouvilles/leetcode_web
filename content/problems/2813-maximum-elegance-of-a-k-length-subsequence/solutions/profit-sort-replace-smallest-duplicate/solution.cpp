class Solution {
    public:long long findMaximumElegance(vector<vector<int>>& items,int k){
        sort(items.begin(),items.end(),[](auto& a,auto& b){
            return a[0]>b[0];
        });
        unordered_set<int> categories;
        priority_queue<int,vector<int>,greater<int>> duplicates;
        long long sum=0;
        for(int i=0;i<k;++i){
            sum+=items[i][0];
            if(!categories.insert(items[i][1]).second)duplicates.push(items[i][0]);
        }
        long long answer=sum+(long long)categories.size()*(long long)categories.size();
        for(int i=k;i<(int)items.size()&&!duplicates.empty();++i)if(!categories.count(items[i][1])){
            sum+=items[i][0]-duplicates.top();
            duplicates.pop();
            categories.insert(items[i][1]);
            answer=max(answer,sum+(long long)categories.size()*(long long)categories.size());
        }
        return answer;
    }
};
