class Solution {
    public: double angleClock(int hour,int minutes){
        double minuteAngle=minutes*6.0,hourAngle=hour%12*30.0+minutes*0.5,difference=abs(hourAngle-minuteAngle);
        return min(difference,360.0-difference);
    }
};
