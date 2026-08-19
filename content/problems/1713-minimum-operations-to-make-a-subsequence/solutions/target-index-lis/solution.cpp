class Solution {
    public: int minOperations(vector<int>& target,vector<int>& arr){
        unordered_map<int,int> index;
        for(int i=0;i<(int)target.size();++i)index[target[i]]=i;
        vector<int> tails;
        for(int value:arr)if(index.count(value)){
            int position=index[value];
            auto place=lower_bound(tails.begin(),tails.end(),position);
            if(place==tails.end())tails.push_back(position);
            else *place=position;
        }
        return target.size()-tails.size();
    }
};
