class Solution {
    private fun leap(year:Int)=year%400==0||year%4==0&&year%100!=0;
    private fun days(date:String):Int{
        val(year,month,day)=date.split('-').map{
            it.toInt()
        };
        var total=0;
        for(y in 1971 until year)total+=if(leap(y))366 else 365;
        val lengths=intArrayOf(31,28,31,30,31,30,31,31,30,31,30,31);
        if(leap(year))lengths[1]=29;
        for(m in 1 until month)total+=lengths[m-1];
        return total+day
    };
    fun daysBetweenDates(date1:String,date2:String)=kotlin.math.abs(days(date1)-days(date2))
}
