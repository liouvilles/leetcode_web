class Solution { public long waysToBuyPensPencils(int total,int cost1,int cost2){long ways=0;for(long pens=0;pens*cost1<=total;pens++)ways+=(total-pens*cost1)/cost2+1;return ways;} }
