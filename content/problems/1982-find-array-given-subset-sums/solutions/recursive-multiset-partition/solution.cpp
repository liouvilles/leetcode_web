class Solution {
    vector<int> answer;
    void recover(vector<int> sums){
        if(sums.size()==1)return;
        int difference=sums[1]-sums[0];
        unordered_map<int,int> count;
        for(int value:sums)++count[value];
        vector<int> first,second;
        for(int value:sums)if(count[value]){
            --count[value];
            --count[value+difference];
            first.push_back(value);
            second.push_back(value+difference);
        }
        if(find(first.begin(),first.end(),0)!=first.end()){
            answer.push_back(difference);
            recover(first);
        }else{
            answer.push_back(-difference);
            recover(second);
        }
    }
    public: vector<int> recoverArray(int n,vector<int>& sums){
        sort(sums.begin(),sums.end());
        recover(sums);
        return answer;
    }
};
