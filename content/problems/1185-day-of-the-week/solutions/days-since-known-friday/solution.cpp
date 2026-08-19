class Solution {
    bool leap(int year){
        return year%400==0||year%4==0&&year%100!=0;
    }
    public:string dayOfTheWeek(int day,int month,int year){
        vector<string> names={
            "Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"
        };
        int days=0;
        for(int current=1971;current<year;++current)days+=leap(current)?366:365;
        int monthDays[]={
            31,28,31,30,31,30,31,31,30,31,30,31
        };
        for(int current=1;current<month;++current)days+=monthDays[current-1]+(current==2&&leap(year));
        days+=day-1;
        return names[(5+days)%7];
    }
};
