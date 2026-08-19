class Solution {
    public int numberOfBoomerangs(int[][] points){
        int answer=0;
        for(int[] center:points){
            Map<Long,Integer> counts=new HashMap<>();
            for(int[] point:points){
                long dx=(long)center[0]-point[0],dy=(long)center[1]-point[1],distance=dx*dx+dy*dy;
                int count=counts.getOrDefault(distance,0);
                answer+=2*count;
                counts.put(distance,count+1);
            }
        }
        return answer;
    }
}
