class Solution { fun sumOfThree(num:Long):LongArray{if(num%3L!=0L)return longArrayOf();val middle=num/3;return longArrayOf(middle-1,middle,middle+1)} }
