class MapSum {
    private val values=hashMapOf<String,Int>();
    private val prefixSums=hashMapOf<String,Int>();
    fun insert(key:String,`val`:Int){
        val delta=`val`-(values[key]?:0);
        values[key]=`val`;
        for(end in 1..key.length){
            val prefix=key.substring(0,end);
            prefixSums[prefix]=(prefixSums[prefix]?:0)+delta
        }
    };
    fun sum(prefix:String):Int=prefixSums[prefix]?:0
}
