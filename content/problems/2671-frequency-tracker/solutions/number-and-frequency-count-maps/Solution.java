class FrequencyTracker {
    private final Map<Integer,Integer> numberCount=new HashMap<>(),frequencyCount=new HashMap<>();
    public FrequencyTracker(){
    }
    private void change(int number,int next){
        int old=numberCount.getOrDefault(number,0);
        if(old>0){
            frequencyCount.put(old,frequencyCount.get(old)-1);
            if(frequencyCount.get(old)==0)frequencyCount.remove(old);
        }
        if(next>0){
            numberCount.put(number,next);
            frequencyCount.merge(next,1,Integer::sum);
        }else numberCount.remove(number);
    }
    public void add(int number){
        change(number,numberCount.getOrDefault(number,0)+1);
    }
    public void deleteOne(int number){
        int old=numberCount.getOrDefault(number,0);
        if(old>0)change(number,old-1);
    }
    public boolean hasFrequency(int frequency){
        return frequencyCount.getOrDefault(frequency,0)>0;
    }
}
