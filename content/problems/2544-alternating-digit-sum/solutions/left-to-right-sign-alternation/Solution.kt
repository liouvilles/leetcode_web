class Solution { fun alternateDigitSum(n:Int):Int{return n.toString().mapIndexed{i,c->(if(i%2==0)1 else -1)*(c-'0')}.sum()} }
