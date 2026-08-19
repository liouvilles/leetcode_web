class ThroneInheritance {
    private final String king;
    private final Map<String,List<String>> children=new HashMap<>();
    private final Set<String> dead=new HashSet<>();
    public ThroneInheritance(String kingName){
        king=kingName;
    }
    public void birth(String parentName,String childName){
        children.computeIfAbsent(parentName,key->new ArrayList<>()).add(childName);
    }
    public void death(String name){
        dead.add(name);
    }
    private void dfs(String name,List<String> order){
        if(!dead.contains(name))order.add(name);
        for(String child:children.getOrDefault(name,Collections.emptyList()))dfs(child,order);
    }
    public List<String> getInheritanceOrder(){
        List<String> order=new ArrayList<>();
        dfs(king,order);
        return order;
    }
}
