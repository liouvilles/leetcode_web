class Solution { public: int balancedStringSplit(string s){int balance=0,answer=0;for(char ch:s){balance+=ch=='L'?1:-1;if(!balance)++answer;}return answer;} };
