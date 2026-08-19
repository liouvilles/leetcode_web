class Solution { fun pivotInteger(n:Int):Int{val total=n*(n+1)/2;val root=kotlin.math.sqrt(total.toDouble()).toInt();return if(root*root==total)root else -1} }
