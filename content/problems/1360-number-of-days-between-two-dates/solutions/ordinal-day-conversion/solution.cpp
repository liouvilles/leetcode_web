class Solution {
    bool leap(int year){
        return year%400==0||(year%4==0&&year%100!=0);
    }
    int days(string date){
        int year=stoi(date.substr(0,4)),month=stoi(date.substr(5,2)),day=stoi(date.substr(8,2)),total=0;
        for(int y=1971;y<year;++y)total+=leap(y)?366:365;
        int lengths[]={
            31,28,31,30,31,30,31,31,30,31,30,31
        };
        if(leap(year))lengths[1]=29;
        for(int m=1;m<month;++m)total+=lengths[m-1];
        return total+day;
    }
    public:int daysBetweenDates(string date1,string date2){
        return abs(days(date1)-days(date2));
    }
};
