class Solution {
    public: vector<string> findRestaurant(vector<string>& list1,vector<string>& list2){
        unordered_map<string,int> indices;
        for(int i=0;i<(int)list1.size();++i)indices[list1[i]]=i;
        vector<string> answer;
        int best=INT_MAX;
        for(int i=0;i<(int)list2.size();++i)if(indices.count(list2[i])){
            int sum=indices[list2[i]]+i;
            if(sum<best){
                best=sum;
                answer.clear();
                answer.push_back(list2[i]);
            }else if(sum==best)answer.push_back(list2[i]);
        }
        return answer;
    }
};
