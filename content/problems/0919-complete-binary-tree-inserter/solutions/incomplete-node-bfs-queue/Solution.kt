class CBTInserter(private val root:TreeNode){
    private val candidates=java.util.ArrayDeque<TreeNode>();
    init{
        val queue=java.util.ArrayDeque<TreeNode>();
        queue.addLast(root);
        while(queue.isNotEmpty()){
            val node=queue.removeFirst();
            if(node.left==null||node.right==null)candidates.addLast(node);
            node.left?.let{
                queue.addLast(it)
            };
            node.right?.let{
                queue.addLast(it)
            }
        }
    };
    fun insert(value:Int):Int{
        val parent=candidates.peekFirst();
        val node=TreeNode(value);
        if(parent.left==null)parent.left=node else{
            parent.right=node;
            candidates.removeFirst()
        };
        candidates.addLast(node);
        return parent.`val`
    };
    fun get_root():TreeNode=root
}
