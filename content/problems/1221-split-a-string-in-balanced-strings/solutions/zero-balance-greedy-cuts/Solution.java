class Solution { public int balancedStringSplit(String s){int balance=0,answer=0;for(char ch:s.toCharArray()){balance+=ch=='L'?1:-1;if(balance==0)answer++;}return answer;} }
