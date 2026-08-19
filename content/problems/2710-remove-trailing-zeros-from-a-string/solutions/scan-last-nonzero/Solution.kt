class Solution { fun removeTrailingZeros(num:String):String{var end=num.lastIndex;while(num[end]=='0')end--;return num.substring(0,end+1)} }
