class Solution {
    private boolean feasible(long amount,int budget,List<List<Integer>> composition,List<Integer> stock,List<Integer> cost){
        for(List<Integer> recipe:composition){
            long spent=0;
            for(int metal=0;metal<stock.size();metal++){
                long shortage=amount*recipe.get(metal)-stock.get(metal);
                if(shortage>0){
                    spent+=shortage*cost.get(metal);
                    if(spent>budget)break;
                }
            }
            if(spent<=budget)return true;
        }
        return false;
    }
    public int maxNumberOfAlloys(int n,int k,int budget,List<List<Integer>> composition,List<Integer> stock,List<Integer> cost){
        long upper=0;
        for(List<Integer> recipe:composition){
            long machineUpper=Long.MAX_VALUE;
            for(int metal=0;metal<n;metal++){
                long individuallyAffordable=stock.get(metal)+(long)budget/cost.get(metal);
                machineUpper=Math.min(machineUpper,individuallyAffordable/recipe.get(metal));
            }
            upper=Math.max(upper,machineUpper);
        }
        long low=0,high=upper+1;
        while(low+1<high){
            long middle=(low+high)/2;
            if(feasible(middle,budget,composition,stock,cost))low=middle;
            else high=middle;
        }
        return (int)low;
    }
}
