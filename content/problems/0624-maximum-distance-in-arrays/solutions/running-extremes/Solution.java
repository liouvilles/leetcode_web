class Solution {
    public int maxDistance(List<List<Integer>> arrays){
        int minimum=arrays.get(0).get(0),maximum=arrays.get(0).get(arrays.get(0).size()-1),best=0;
        for(int i=1;i<arrays.size();i++){
            List<Integer> array=arrays.get(i);
            int first=array.get(0),last=array.get(array.size()-1);
            best=Math.max(best,Math.max(Math.abs(last-minimum),Math.abs(maximum-first)));
            minimum=Math.min(minimum,first);
            maximum=Math.max(maximum,last);
        }
        return best;
    }
}
