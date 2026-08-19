class Solution {
    class Node{
        val children=java.util.TreeMap<String,Node>();
        var signature=""
    };
    private lateinit var root:Node;
    private val counts=HashMap<String,Int>();
    private fun encode(node:Node):String{
        val builder=StringBuilder();
        for((name,child) in node.children)builder.append('(').append(name).append(encode(child)).append(')');
        node.signature=builder.toString();
        if(node!==root&&node.children.isNotEmpty())counts[node.signature]=(counts[node.signature]?:0)+1;
        return node.signature
    };
    private fun collect(node:Node,path:MutableList<String>,answer:MutableList<List<String>>){
        for((name,child) in node.children){
            if(child.children.isNotEmpty()&&(counts[child.signature]?:0)>1)continue;
            path.add(name);
            answer.add(path.toList());
            collect(child,path,answer);
            path.removeAt(path.lastIndex)
        }
    };
    fun deleteDuplicateFolder(paths:List<List<String>>):List<List<String>>{
        root=Node();
        for(path in paths){
            var node=root;
            for(name in path)node=node.children.getOrPut(name){
                Node()
            }
        };
        encode(root);
        val answer=mutableListOf<List<String>>();
        collect(root,mutableListOf(),answer);
        return answer
    }
}
