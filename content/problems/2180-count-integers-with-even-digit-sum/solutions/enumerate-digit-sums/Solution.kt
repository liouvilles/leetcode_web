class Solution { fun countEven(num:Int):Int{var answer=0;for(value in 1..num){var current=value;var sum=0;while(current>0){sum+=current%10;current/=10};if(sum%2==0)answer++};return answer} }
