class Solution {
    fun beautifulArray(n:Int):IntArray{
        var values=listOf(1);
        while(values.size<n){
            val next=mutableListOf<Int>();
            for(x in values)if(2*x-1<=n)next.add(2*x-1);
            for(x in values)if(2*x<=n)next.add(2*x);
            values=next
        };
        return values.toIntArray()
    }
}
