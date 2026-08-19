class RangeModule {
    private final TreeMap<Integer,Integer> intervals=new TreeMap<>();
    public RangeModule(){
    }
    public void addRange(int left,int right){
        Map.Entry<Integer,Integer> entry=intervals.floorEntry(left);
        if(entry==null||entry.getValue()<left)entry=intervals.ceilingEntry(left);
        List<Integer> keys=new ArrayList<>();
        while(entry!=null&&entry.getKey()<=right){
            if(entry.getValue()>=left)keys.add(entry.getKey());
            entry=intervals.higherEntry(entry.getKey());
        }
        for(int key:keys){
            left=Math.min(left,key);
            right=Math.max(right,intervals.remove(key));
        }
        intervals.put(left,right);
    }
    public boolean queryRange(int left,int right){
        Map.Entry<Integer,Integer> entry=intervals.floorEntry(left);
        return entry!=null&&entry.getValue()>=right;
    }
    public void removeRange(int left,int right){
        Map.Entry<Integer,Integer> entry=intervals.floorEntry(left);
        if(entry==null||entry.getValue()<=left)entry=intervals.ceilingEntry(left);
        List<int[]> overlaps=new ArrayList<>();
        while(entry!=null&&entry.getKey()<right){
            if(entry.getValue()>left)overlaps.add(new int[]{
                entry.getKey(),entry.getValue()
            });
            entry=intervals.higherEntry(entry.getKey());
        }
        for(int[] interval:overlaps){
            intervals.remove(interval[0]);
            if(interval[0]<left)intervals.put(interval[0],left);
            if(interval[1]>right)intervals.put(right,interval[1]);
        }
    }
}
