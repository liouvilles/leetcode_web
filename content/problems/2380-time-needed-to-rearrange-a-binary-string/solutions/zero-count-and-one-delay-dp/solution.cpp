class Solution { public:int secondsToRemoveOccurrences(string s){int zeros=0,answer=0;for(char ch:s)if(ch=='0')++zeros;else if(zeros)answer=max(zeros,answer+1);return answer;} };
