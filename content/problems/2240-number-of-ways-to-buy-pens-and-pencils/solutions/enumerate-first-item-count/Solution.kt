class Solution { fun waysToBuyPensPencils(total:Int,cost1:Int,cost2:Int):Long{var ways=0L;var pens=0L;while(pens*cost1<=total){ways+=(total-pens*cost1)/cost2+1;pens++};return ways} }
