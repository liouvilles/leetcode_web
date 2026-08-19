class Solution {
    public String destCity(List<List<String>> paths){
        Set<String> origins=new HashSet<>();
        for(List<String> path:paths)origins.add(path.get(0));
        for(List<String> path:paths)if(!origins.contains(path.get(1)))return path.get(1);
        return "";
    }
}
