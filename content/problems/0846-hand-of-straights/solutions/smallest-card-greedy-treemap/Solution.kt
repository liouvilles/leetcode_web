class Solution {
    fun isNStraightHand(hand:IntArray,groupSize:Int):Boolean{
        if(hand.size%groupSize!=0)return false;
        val count=java.util.TreeMap<Int,Int>();
        for(value in hand)count[value]=(count[value]?:0)+1;
        while(count.isNotEmpty()){
            val start=count.firstKey();
            for(value in start until start+groupSize){
                val frequency=count[value]?:return false;
                if(frequency==1)count.remove(value)else count[value]=frequency-1
            }
        };
        return true
    }
}
