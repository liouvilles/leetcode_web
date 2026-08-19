class Solution {
    public int dayOfYear(String date){
        int year=Integer.parseInt(date.substring(0,4)),month=Integer.parseInt(date.substring(5,7)),day=Integer.parseInt(date.substring(8));
        int[] days={
            31,28,31,30,31,30,31,31,30,31,30,31
        };
        for(int i=1;i<month;i++)day+=days[i-1];
        if(month>2&&(year%400==0||year%4==0&&year%100!=0))day++;
        return day;
    }
}
