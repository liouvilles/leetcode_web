class Solution {
    private lateinit var parent:IntArray;
    private lateinit var size:IntArray;
    private fun find(valueValue:Int):Int{
        var value=valueValue;
        if(parent[value]!=value)parent[value]=find(parent[value]);
        return parent[value]
    };
    private fun union(firstValue:Int,secondValue:Int){
        var a=find(firstValue);
        var b=find(secondValue);
        if(a==b)return;
        if(size[a]<size[b]){
            val temp=a;
            a=b;
            b=temp
        };
        parent[b]=a;
        size[a]+=size[b]
    };
    fun groupStrings(words:Array<String>):IntArray{
        val n=words.size;
        parent=IntArray(n){
            it
        };
        size=IntArray(n){
            1
        };
        val masks=HashMap<Int,Int>();
        val values=IntArray(n);
        for(i in words.indices){
            var mask=0;
            for(ch in words[i])mask=mask or (1 shl (ch-'a'));
            values[i]=mask;
            if(mask in masks)union(i,masks[mask]!!)else masks[mask]=i
        };
        val removedOwner=HashMap<Int,Int>();
        for(i in words.indices){
            var bits=values[i];
            while(bits!=0){
                val removed=values[i] xor (bits and -bits);
                if(removed in masks)union(i,masks[removed]!!);
                if(removed in removedOwner)union(i,removedOwner[removed]!!)else removedOwner[removed]=i;
                bits=bits and (bits-1)
            }
        };
        val roots=HashSet<Int>();
        var maximum=0;
        for(i in words.indices){
            val root=find(i);
            roots.add(root);
            maximum=maxOf(maximum,size[root])
        };
        return intArrayOf(roots.size,maximum)
    }
}
