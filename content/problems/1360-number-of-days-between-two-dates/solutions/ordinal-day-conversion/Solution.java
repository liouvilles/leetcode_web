class Solution {
    private boolean leap(int year){
        return year%400==0||year%4==0&&year%100!=0;
    }
    private int days(String date){
        String[] part=date.split("-");
        int year=Integer.parseInt(part[0]),month=Integer.parseInt(part[1]),day=Integer.parseInt(part[2]),total=0;
        for(int y=1971;y<year;y++)total+=leap(y)?366:365;
        int[] lengths={
            31,28,31,30,31,30,31,31,30,31,30,31
        };
        if(leap(year))lengths[1]=29;
        for(int m=1;m<month;m++)total+=lengths[m-1];
        return total+day;
    }
    public int daysBetweenDates(String date1,String date2){
        return Math.abs(days(date1)-days(date2));
    }
}
