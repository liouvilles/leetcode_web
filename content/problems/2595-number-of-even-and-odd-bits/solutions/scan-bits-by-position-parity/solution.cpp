class Solution { public:vector<int> evenOddBit(int n){vector<int> answer(2);for(int position=0;n; ++position,n>>=1)if(n&1)++answer[position&1];return answer;} };
