class Solution { public:vector<int> findArray(vector<int>& pref){vector<int> answer(pref.size());answer[0]=pref[0];for(int i=1;i<(int)pref.size();++i)answer[i]=pref[i-1]^pref[i];return answer;} };
