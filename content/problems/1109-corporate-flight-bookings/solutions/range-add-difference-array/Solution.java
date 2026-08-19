class Solution {
    public int[] corpFlightBookings(int[][] bookings,int n){
        int[] difference=new int[n+1];
        for(int[] booking:bookings){
            difference[booking[0]-1]+=booking[2];
            difference[booking[1]]-=booking[2];
        }
        int[] answer=new int[n];
        int running=0;
        for(int i=0;i<n;i++)answer[i]=running+=difference[i];
        return answer;
    }
}
