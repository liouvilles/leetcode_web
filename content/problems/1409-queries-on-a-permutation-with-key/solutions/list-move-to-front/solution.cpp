class Solution {
    public: vector<int> processQueries(vector<int>& queries,int m){
        vector<int> permutation(m),answer;
        iota(permutation.begin(),permutation.end(),1);
        for(int query:queries){
            int index=find(permutation.begin(),permutation.end(),query)-permutation.begin();
            answer.push_back(index);
            permutation.erase(permutation.begin()+index);
            permutation.insert(permutation.begin(),query);
        }
        return answer;
    }
};
