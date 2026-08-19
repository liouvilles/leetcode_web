class Solution { public:long long countSubstrings(string s,char c){long long count=count_if(s.begin(),s.end(),[&](char letter){return letter==c;});return count*(count+1)/2;} };
