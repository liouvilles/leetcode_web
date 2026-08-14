class Solution { fun maximumScore(a:Int,b:Int,c:Int):Int{val total=a+b+c;val maximum=maxOf(a,b,c);return minOf(total-maximum,total/2)} }
