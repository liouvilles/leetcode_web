class Solution { fun partitionString(s:String):Int{var groups=1;var mask=0;for(ch in s){val bit=1 shl (ch-'a');if(mask and bit!=0){groups++;mask=0};mask=mask or bit};return groups} }
