class Solution {
    fun dayOfTheWeek(day:Int,month:Int,year:Int):String{
        val names=arrayOf("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday");
        var days=0;
        for(current in 1971 until year)days+=if(leap(current))366 else 365;
        val monthDays=intArrayOf(31,28,31,30,31,30,31,31,30,31,30,31);
        for(current in 1 until month)days+=monthDays[current-1]+if(current==2&&leap(year))1 else 0;
        days+=day-1;
        return names[(5+days)%7]
    };
    private fun leap(year:Int)=year%400==0||year%4==0&&year%100!=0
}
