class CountIntervals {
    TreeMap<Integer,Integer> intervals=new TreeMap<>();
    long covered;
    public CountIntervals(){
    }
    public void add(int left,int right){
        Map.Entry<Integer,Integer> entry=intervals.floorEntry(left);
        if(entry==null||entry.getValue()+1<left)entry=intervals.ceilingEntry(left);
        while(entry!=null&&entry.getKey()<=right+1){
            left=Math.min(left,entry.getKey());
            right=Math.max(right,entry.getValue());
            covered-=entry.getValue()-entry.getKey()+1L;
            intervals.remove(entry.getKey());
            entry=intervals.ceilingEntry(left);
        }
        intervals.put(left,right);
        covered+=right-left+1L;
    }
    public int count(){
        return (int)covered;
    }
}
