class Solution {
    public String dayOfTheWeek(int day,int month,int year){
        String[] names={
            "Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"
        };
        int days=0;
        for(int current=1971;current<year;current++)days+=leap(current)?366:365;
        int[] monthDays={
            31,28,31,30,31,30,31,31,30,31,30,31
        };
        for(int current=1;current<month;current++)days+=monthDays[current-1]+(current==2&&leap(year)?1:0);
        days+=day-1;
        return names[(5+days)%7];
    }
    private boolean leap(int year){
        return year%400==0||year%4==0&&year%100!=0;
    }
}
