class FrequencyTracker {
    private val numberCount=HashMap<Int,Int>();
    private val frequencyCount=HashMap<Int,Int>();
    private fun change(number:Int,next:Int){
        val old=numberCount.getOrDefault(number,0);
        if(old>0){
            frequencyCount[old]=frequencyCount[old]!!-1;
            if(frequencyCount[old]==0)frequencyCount.remove(old)
        };
        if(next>0){
            numberCount[number]=next;
            frequencyCount[next]=frequencyCount.getOrDefault(next,0)+1
        }else numberCount.remove(number)
    }
    fun add(number:Int){
        change(number,numberCount.getOrDefault(number,0)+1)
    }
    fun deleteOne(number:Int){
        val old=numberCount.getOrDefault(number,0);
        if(old>0)change(number,old-1)
    }
    fun hasFrequency(frequency:Int)=frequencyCount.getOrDefault(frequency,0)>0
}
