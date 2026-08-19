class Solution {
    public int[] avoidFlood(int[] rains){
        int[] answer=new int[rains.length];
        Arrays.fill(answer,1);
        Map<Integer,Integer> lastRain=new HashMap<>();
        TreeSet<Integer> dryDays=new TreeSet<>();
        for(int day=0;day<rains.length;day++)if(rains[day]==0)dryDays.add(day);
        else{
            int lake=rains[day];
            answer[day]=-1;
            if(lastRain.containsKey(lake)){
                Integer dry=dryDays.higher(lastRain.get(lake));
                if(dry==null)return new int[0];
                answer[dry]=lake;
                dryDays.remove(dry);
            }
            lastRain.put(lake,day);
        }
        return answer;
    }
}
