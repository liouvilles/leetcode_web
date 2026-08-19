class Solution {
    public int maxNumberOfFamilies(int n,int[][] reservedSeats){
        Map<Integer,Integer> rows=new HashMap<>();
        for(int[] seat:reservedSeats)if(seat[1]>=2&&seat[1]<=9)rows.merge(seat[0],1<<seat[1],(a,b)->a|b);
        int answer=(n-rows.size())*2;
        int left=0,middle=0,right=0;
        for(int seat=2;seat<=5;seat++)left|=1<<seat;
        for(int seat=4;seat<=7;seat++)middle|=1<<seat;
        for(int seat=6;seat<=9;seat++)right|=1<<seat;
        for(int mask:rows.values()){
            boolean leftFree=(mask&left)==0,middleFree=(mask&middle)==0,rightFree=(mask&right)==0;
            if(leftFree&&rightFree)answer+=2;
            else if(leftFree||middleFree||rightFree)answer++;
        }
        return answer;
    }
}
