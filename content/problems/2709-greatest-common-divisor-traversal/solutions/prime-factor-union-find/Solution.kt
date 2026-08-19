class Solution {
    fun canTraverseAllPairs(nums:IntArray):Boolean{
        val n=nums.size;
        if(n==1)return true;
        if(nums.any{
            it==1
        })return false;
        val maximum=nums.maxOrNull()!!;
        val spf=IntArray(maximum+1);
        for(prime in 2..maximum)if(spf[prime]==0){
            var multiple=prime;
            while(multiple<=maximum){
                if(spf[multiple]==0)spf[multiple]=prime;
                multiple+=prime
            }
        };
        val parent=IntArray(n){
            it
        };
        val size=IntArray(n){
            1
        };
        fun find(input:Int):Int{
            var value=input;
            while(parent[value]!=value){
                parent[value]=parent[parent[value]];
                value=parent[value]
            };
            return value
        };
        fun union(first:Int,second:Int){
            var a=find(first);
            var b=find(second);
            if(a==b)return;
            if(size[a]<size[b]){
                val swap=a;
                a=b;
                b=swap
            };
            parent[b]=a;
            size[a]+=size[b]
        };
        val owner=HashMap<Int,Int>();
        for(i in nums.indices){
            var value=nums[i];
            while(value>1){
                val prime=spf[value];
                owner[prime]?.let{
                    union(i,it)
                }?:run{
                    owner[prime]=i
                };
                while(value%prime==0)value/=prime
            }
        };
        val root=find(0);
        return (1 until n).all{
            find(it)==root
        }
    }
}
