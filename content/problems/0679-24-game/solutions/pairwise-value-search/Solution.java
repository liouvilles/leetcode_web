class Solution {
    public boolean judgePoint24(int[] cards){
        List<Double> values=new ArrayList<>();
        for(int card:cards)values.add((double)card);
        return search(values);
    }
    private boolean search(List<Double> values){
        if(values.size()==1)return Math.abs(values.get(0)-24)<1e-6;
        for(int i=0;i<values.size();i++)for(int j=i+1;j<values.size();j++){
            double a=values.get(i),b=values.get(j);
            List<Double> rest=new ArrayList<>();
            for(int k=0;k<values.size();k++)if(k!=i&&k!=j)rest.add(values.get(k));
            double[] candidates={
                a+b,a-b,b-a,a*b,a/b,b/a
            };
            for(int operation=0;operation<candidates.length;operation++){
                if(operation==4&&Math.abs(b)<1e-9||operation==5&&Math.abs(a)<1e-9)continue;
                rest.add(candidates[operation]);
                if(search(rest))return true;
                rest.remove(rest.size()-1);
            }
        }
        return false;
    }
}
