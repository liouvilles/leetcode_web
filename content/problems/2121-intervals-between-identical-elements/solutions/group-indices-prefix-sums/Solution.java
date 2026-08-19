class Solution {
    public long[] getDistances(int[] arr){
        Map<Integer,List<Integer>> groups=new HashMap<>();
        for(int i=0;i<arr.length;i++)groups.computeIfAbsent(arr[i],ignored->new ArrayList<>()).add(i);
        long[] answer=new long[arr.length];
        for(List<Integer> indices:groups.values()){
            long total=0,left=0;
            for(int index:indices)total+=index;
            for(int i=0;i<indices.size();i++){
                int index=indices.get(i);
                answer[index]=(long)index*i-left+(total-left-index)-(long)index*(indices.size()-i-1);
                left+=index;
            }
        }
        return answer;
    }
}
