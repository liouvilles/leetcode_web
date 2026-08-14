class Solution { fun minimumNumbers(num:Int,k:Int):Int{if(num==0)return 0;for(count in 1..10)if(count*k<=num&&(num-count*k)%10==0)return count;return -1} }
