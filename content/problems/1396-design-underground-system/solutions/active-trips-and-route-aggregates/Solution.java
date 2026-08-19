class UndergroundSystem {
    private static class CheckIn{
        String station;
        int time;
        CheckIn(String station,int time){
            this.station=station;
            this.time=time;
        }
    }
    private final Map<Integer,CheckIn> active=new HashMap<>();
    private final Map<String,long[]> routes=new HashMap<>();
    public void checkIn(int id,String stationName,int t){
        active.put(id,new CheckIn(stationName,t));
    }
    public void checkOut(int id,String stationName,int t){
        CheckIn start=active.remove(id);
        long[] aggregate=routes.computeIfAbsent(start.station+"#"+stationName,key->new long[2]);
        aggregate[0]+=t-start.time;
        aggregate[1]++;
    }
    public double getAverageTime(String startStation,String endStation){
        long[] aggregate=routes.get(startStation+"#"+endStation);
        return (double)aggregate[0]/aggregate[1];
    }
}
