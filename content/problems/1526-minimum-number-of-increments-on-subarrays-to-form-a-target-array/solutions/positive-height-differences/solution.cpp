class Solution { public: int minNumberOperations(vector<int>& target){int answer=target[0];for(int i=1;i<(int)target.size();++i)answer+=max(0,target[i]-target[i-1]);return answer;} };
