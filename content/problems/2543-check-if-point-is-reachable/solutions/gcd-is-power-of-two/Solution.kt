class Solution { fun isReachable(targetX:Int,targetY:Int):Boolean{var a=targetX;var b=targetY;while(b!=0){val remainder=a%b;a=b;b=remainder};return a and (a-1)==0} }
