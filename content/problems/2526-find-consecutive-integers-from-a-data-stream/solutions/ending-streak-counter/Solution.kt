class DataStream(private val value:Int,private val k:Int) {
    private var streak=0;
    fun consec(num:Int):Boolean{
        streak=if(num==value)streak+1 else 0;
        return streak>=k
    }
}
