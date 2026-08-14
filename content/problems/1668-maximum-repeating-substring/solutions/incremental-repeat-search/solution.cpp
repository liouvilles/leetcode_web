class Solution { public: int maxRepeating(string sequence,string word){string candidate=word;int answer=0;while(sequence.find(candidate)!=string::npos){++answer;candidate+=word;}return answer;} };
