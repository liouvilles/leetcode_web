class Solution { fun reachNumber(targetValue:Int):Int{val target=kotlin.math.abs(targetValue);var step=0;var sum=0;while(sum<target||(sum-target)%2!=0)sum+=++step;return step} }
