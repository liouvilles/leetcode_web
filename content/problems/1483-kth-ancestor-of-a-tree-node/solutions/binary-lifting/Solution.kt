class TreeAncestor(n:Int,parent:IntArray){
    private val up:Array<IntArray>;
    init{
        var log=1;
        while((1 shl log)<=n)log++;
        up=Array(log){
            IntArray(n)
        };
        up[0]=parent.copyOf();
        for(bit in 1 until log)for(node in 0 until n){
            val middle=up[bit-1][node];
            up[bit][node]=if(middle==-1)-1 else up[bit-1][middle]
        }
    };
    fun getKthAncestor(nodeValue:Int,k:Int):Int{
        var node=nodeValue;
        for(bit in up.indices)if(node!=-1&&k and (1 shl bit)!=0)node=up[bit][node];
        return node
    }
}
