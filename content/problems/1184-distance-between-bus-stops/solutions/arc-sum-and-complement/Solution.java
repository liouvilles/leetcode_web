class Solution {
    public int distanceBetweenBusStops(int[] distance,int start,int destination){
        if(start>destination){
            int temporary=start;
            start=destination;
            destination=temporary;
        }
        int total=0,direct=0;
        for(int i=0;i<distance.length;i++){
            total+=distance[i];
            if(i>=start&&i<destination)direct+=distance[i];
        }
        return Math.min(direct,total-direct);
    }
}
