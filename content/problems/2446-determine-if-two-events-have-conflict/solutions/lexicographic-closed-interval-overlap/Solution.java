class Solution {
    public boolean haveConflict(String[] event1,String[] event2){
        String start=event1[0].compareTo(event2[0])>=0?event1[0]:event2[0];
        String end=event1[1].compareTo(event2[1])<=0?event1[1]:event2[1];
        return start.compareTo(end)<=0;
    }
}
