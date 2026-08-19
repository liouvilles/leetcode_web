class MyHashSet {
    private val present=BooleanArray(1000001);
    fun add(key:Int){
        present[key]=true
    };
    fun remove(key:Int){
        present[key]=false
    };
    fun contains(key:Int):Boolean=present[key]
}
