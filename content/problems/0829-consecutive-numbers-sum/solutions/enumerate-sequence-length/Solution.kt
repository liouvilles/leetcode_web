class Solution { fun consecutiveNumbersSum(n:Int):Int{var answer=0;var length=1L;while(length*(length-1)/2<n){if((n-length*(length-1)/2)%length==0L)answer++;length++};return answer} }
