class MyHashMap {
    private val values=IntArray(1000001){
        -1
    };
    fun put(key:Int,value:Int){
        values[key]=value
    };
    fun get(key:Int):Int=values[key];
    fun remove(key:Int){
        values[key]=-1
    }
}
