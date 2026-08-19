class Solution {
    fun readBinaryWatch(turnedOn:Int):List<String>{
        val answer=mutableListOf<String>();
        for(hour in 0..11)for(minute in 0..59)if(Integer.bitCount(hour)+Integer.bitCount(minute)==turnedOn)answer.add(hour.toString()+":"+(if(minute<10)"0" else "")+minute);
        return answer
    }
}
