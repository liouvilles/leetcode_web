class Solution {
    public int latestTimeCatchTheBus(int[] buses,int[] passengers,int capacity){
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int index=0,candidate=0;
        for(int busIndex=0;busIndex<buses.length;busIndex++){
            int boarded=0;
            while(index<passengers.length&&passengers[index]<=buses[busIndex]&&boarded<capacity){
                index++;
                boarded++;
            }
            if(busIndex==buses.length-1)candidate=boarded<capacity?buses[busIndex]:passengers[index-1]-1;
        }
        Set<Integer> occupied=new HashSet<>();
        for(int time:passengers)occupied.add(time);
        while(occupied.contains(candidate))candidate--;
        return candidate;
    }
}
