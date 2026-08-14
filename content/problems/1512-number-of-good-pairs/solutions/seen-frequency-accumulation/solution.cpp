class Solution { public: int numIdenticalPairs(vector<int>& nums){unordered_map<int,int> count;int answer=0;for(int value:nums){answer+=count[value];++count[value];}return answer;} };
