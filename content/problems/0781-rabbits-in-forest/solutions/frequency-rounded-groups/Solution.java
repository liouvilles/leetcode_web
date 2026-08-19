class Solution {
    public int numRabbits(int[] answers){
        Map<Integer,Integer> frequency=new HashMap<>();
        for(int answer:answers)frequency.merge(answer,1,Integer::sum);
        int result=0;
        for(Map.Entry<Integer,Integer> entry:frequency.entrySet()){
            int size=entry.getKey()+1,count=entry.getValue();
            result+=(count+size-1)/size*size;
        }
        return result;
    }
}
