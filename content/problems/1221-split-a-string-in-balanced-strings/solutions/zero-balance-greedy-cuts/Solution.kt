class Solution { fun balancedStringSplit(s:String):Int{var balance=0;var answer=0;for(ch in s){balance+=if(ch=='L')1 else -1;if(balance==0)answer++};return answer} }
