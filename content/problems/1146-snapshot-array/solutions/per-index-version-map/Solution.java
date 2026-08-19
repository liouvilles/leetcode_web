class SnapshotArray {
    private final List<TreeMap<Integer,Integer>> history=new ArrayList<>();
    private int currentSnap=0;
    public SnapshotArray(int length){
        for(int i=0;i<length;i++){
            TreeMap<Integer,Integer> versions=new TreeMap<>();
            versions.put(0,0);
            history.add(versions);
        }
    }
    public void set(int index,int val){
        history.get(index).put(currentSnap,val);
    }
    public int snap(){
        return currentSnap++;
    }
    public int get(int index,int snapId){
        return history.get(index).floorEntry(snapId).getValue();
    }
}
