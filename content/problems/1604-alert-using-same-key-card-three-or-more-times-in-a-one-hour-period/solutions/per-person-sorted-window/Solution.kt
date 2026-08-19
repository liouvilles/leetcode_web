class Solution {
    fun alertNames(keyName:Array<String>,keyTime:Array<String>):List<String>{
        val times=mutableMapOf<String,MutableList<Int>>();
        for(i in keyName.indices){
            val(hour,minute)=keyTime[i].split(':').map{
                it.toInt()
            };
            times.getOrPut(keyName[i]){
                mutableListOf()
            }.add(hour*60+minute)
        };
        return times.filter{
            entry->entry.value.sorted().windowed(3).any{
                it[2]-it[0]<=60
            }
        }.keys.sorted()
    }
}
