class Solution {
    fun countPairs(n:Int,edges:Array<IntArray>,queries:IntArray):IntArray{
        val degree=IntArray(n);
        val multiplicity=mutableMapOf<Long,Int>();
        for(edge in edges){
            var a=edge[0]-1;
            var b=edge[1]-1;
            if(a>b){
                val temporary=a;
                a=b;
                b=temporary
            };
            degree[a]++;
            degree[b]++;
            val key=a.toLong()*n+b;
            multiplicity[key]=(multiplicity[key]?:0)+1
        };
        val sorted=degree.sorted();
        return IntArray(queries.size){
            index->var left=0;
            var right=n-1;
            var count=0;
            while(left<right)if(sorted[left]+sorted[right]>queries[index]){
                count+=right-left;
                right--
            }else left++;
            for((key,times) in multiplicity){
                val a=(key/n).toInt();
                val b=(key%n).toInt();
                val sum=degree[a]+degree[b];
                if(sum>queries[index]&&sum-times<=queries[index])count--
            };
            count
        }
    }
}
