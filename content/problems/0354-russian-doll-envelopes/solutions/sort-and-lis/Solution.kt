class Solution {
    fun maxEnvelopes(envelopes:Array<IntArray>):Int{
        envelopes.sortWith(Comparator{
            a,b->if(a[0]==b[0])b[1].compareTo(a[1]) else a[0].compareTo(b[0])
        });
        val tails=IntArray(envelopes.size);
        var size=0;
        for(envelope in envelopes){
            var left=0;
            var right=size;
            while(left<right){
                val middle=(left+right)/2;
                if(tails[middle]<envelope[1])left=middle+1 else right=middle
            };
            tails[left]=envelope[1];
            if(left==size)size++
        };
        return size
    }
}
