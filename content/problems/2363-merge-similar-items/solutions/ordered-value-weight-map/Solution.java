class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1,int[][] items2){
        TreeMap<Integer,Integer> weights=new TreeMap<>();
        for(int[] item:items1)weights.merge(item[0],item[1],Integer::sum);
        for(int[] item:items2)weights.merge(item[0],item[1],Integer::sum);
        List<List<Integer>> answer=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:weights.entrySet())answer.add(Arrays.asList(entry.getKey(),entry.getValue()));
        return answer;
    }
}
