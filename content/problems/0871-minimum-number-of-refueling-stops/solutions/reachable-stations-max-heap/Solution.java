class Solution {
    public int minRefuelStops(int target,int startFuel,int[][] stations){
        PriorityQueue<Integer> heap=new PriorityQueue<>(Comparator.reverseOrder());
        long fuel=startFuel;
        int index=0,stops=0;
        while(fuel<target){
            while(index<stations.length&&stations[index][0]<=fuel)heap.offer(stations[index++][1]);
            if(heap.isEmpty())return -1;
            fuel+=heap.poll();
            stops++;
        }
        return stops;
    }
}
