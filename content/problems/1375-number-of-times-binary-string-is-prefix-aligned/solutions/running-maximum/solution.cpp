class Solution { public: int numTimesAllBlue(vector<int>& flips){int maximum=0,answer=0;for(int i=0;i<(int)flips.size();++i){maximum=max(maximum,flips[i]);if(maximum==i+1)++answer;}return answer;} };
