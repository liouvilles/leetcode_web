class ProductOfNumbers {
    private val prefix=mutableListOf(1);
    fun add(num:Int){
        if(num==0){
            prefix.clear();
            prefix.add(1)
        }else prefix.add(prefix.last()*num)
    };
    fun getProduct(k:Int):Int=if(k>=prefix.size)0 else prefix.last()/prefix[prefix.lastIndex-k]
}
