class Solution {
    fun reformatDate(date:String):String{
        val parts=date.split(' ');
        val months=listOf("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
        val day=parts[0].dropLast(2).toInt();
        val month=months.indexOf(parts[1])+1;
        return "%04d-%02d-%02d".format(parts[2].toInt(),month,day)
    }
}
