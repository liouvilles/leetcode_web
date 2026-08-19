class Solution {
    static class Node{
        TreeMap<String,Node> children=new TreeMap<>();
        String signature="";
    }
    Node root;
    Map<String,Integer> counts=new HashMap<>();
    private String encode(Node node){
        StringBuilder builder=new StringBuilder();
        for(Map.Entry<String,Node> entry:node.children.entrySet())builder.append('(').append(entry.getKey()).append(encode(entry.getValue())).append(')');
        node.signature=builder.toString();
        if(node!=root&&!node.children.isEmpty())counts.merge(node.signature,1,Integer::sum);
        return node.signature;
    }
    private void collect(Node node,List<String> path,List<List<String>> answer){
        for(Map.Entry<String,Node> entry:node.children.entrySet()){
            Node child=entry.getValue();
            if(!child.children.isEmpty()&&counts.getOrDefault(child.signature,0)>1)continue;
            path.add(entry.getKey());
            answer.add(new ArrayList<>(path));
            collect(child,path,answer);
            path.remove(path.size()-1);
        }
    }
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths){
        root=new Node();
        for(List<String> path:paths){
            Node node=root;
            for(String name:path)node=node.children.computeIfAbsent(name,ignored->new Node());
        }
        encode(root);
        List<List<String>> answer=new ArrayList<>();
        collect(root,new ArrayList<>(),answer);
        return answer;
    }
}
