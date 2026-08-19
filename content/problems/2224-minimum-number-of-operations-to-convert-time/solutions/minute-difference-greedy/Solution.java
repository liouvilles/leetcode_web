class Solution {
    private int minutes(String time){
        return Integer.parseInt(time.substring(0,2))*60+Integer.parseInt(time.substring(3));
    }
    public int convertTime(String current,String correct){
        int difference=minutes(correct)-minutes(current),answer=0;
        for(int step:new int[]{
            60,15,5,1
        }){
            answer+=difference/step;
            difference%=step;
        }
        return answer;
    }
}
