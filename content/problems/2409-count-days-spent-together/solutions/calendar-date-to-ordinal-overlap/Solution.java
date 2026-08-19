class Solution {
    private int day(String date){
        int[] days={
            31,28,31,30,31,30,31,31,30,31,30,31
        };
        int month=Integer.parseInt(date.substring(0,2)),value=Integer.parseInt(date.substring(3));
        for(int i=1;i<month;i++)value+=days[i-1];
        return value;
    }
    public int countDaysTogether(String arriveAlice,String leaveAlice,String arriveBob,String leaveBob){
        return Math.max(0,Math.min(day(leaveAlice),day(leaveBob))-Math.max(day(arriveAlice),day(arriveBob))+1);
    }
}
