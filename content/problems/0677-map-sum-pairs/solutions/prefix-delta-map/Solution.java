class MapSum {
    private final Map<String,Integer> values=new HashMap<>(),prefixSums=new HashMap<>();
    public MapSum(){
    }
    public void insert(String key,int val){
        int delta=val-values.getOrDefault(key,0);
        values.put(key,val);
        for(int end=1;end<=key.length();end++){
            String prefix=key.substring(0,end);
            prefixSums.put(prefix,prefixSums.getOrDefault(prefix,0)+delta);
        }
    }
    public int sum(String prefix){
        return prefixSums.getOrDefault(prefix,0);
    }
}
