class Solution {
    private fun upper(values:IntArray,target:Int):Int{
        var left=0;
        var right=values.size;
        while(left<right){
            val middle=(left+right) ushr 1;
            if(values[middle]<=target)left=middle+1 else right=middle
        };
        return left
    };
    fun minWastedSpace(packages:IntArray,boxes:Array<IntArray>):Int{
        packages.sort();
        val prefix=LongArray(packages.size+1);
        for(i in packages.indices)prefix[i+1]=prefix[i]+packages[i];
        var best=Long.MAX_VALUE;
        for(supplier in boxes){
            supplier.sort();
            if(supplier.last()<packages.last())continue;
            var index=0;
            var waste=0L;
            for(box in supplier){
                val next=upper(packages,box);
                if(next>index){
                    waste+=box.toLong()*(next-index)-(prefix[next]-prefix[index]);
                    index=next
                };
                if(index==packages.size)break
            };
            best=minOf(best,waste)
        };
        return if(best==Long.MAX_VALUE)-1 else (best%1_000_000_007).toInt()
    }
}
