class Solution { fun passThePillow(n:Int,time:Int):Int{val length=n-1;val offset=time%length;return if(time/length%2==0)1+offset else n-offset} }
