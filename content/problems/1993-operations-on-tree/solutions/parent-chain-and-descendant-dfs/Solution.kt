class LockingTree(private val parent:IntArray){
    private val locked=IntArray(parent.size){
        -1
    };
    private val children=Array(parent.size){
        mutableListOf<Int>()
    };
    init{
        for(i in 1 until parent.size)children[parent[i]].add(i)
    }
    fun lock(num:Int,user:Int):Boolean{
        if(locked[num]!=-1)return false;
        locked[num]=user;
        return true
    }
    fun unlock(num:Int,user:Int):Boolean{
        if(locked[num]!=user)return false;
        locked[num]=-1;
        return true
    }
    private fun clear(node:Int):Boolean{
        var found=locked[node]!=-1;
        locked[node]=-1;
        for(child in children[node])found=clear(child)||found;
        return found
    }
    fun upgrade(num:Int,user:Int):Boolean{
        if(locked[num]!=-1)return false;
        var ancestor=parent[num];
        while(ancestor!=-1){
            if(locked[ancestor]!=-1)return false;
            ancestor=parent[ancestor]
        };
        var found=false;
        for(child in children[num])found=clear(child)||found;
        if(!found)return false;
        locked[num]=user;
        return true
    }
}
