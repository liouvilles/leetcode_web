class Solution {
    public int passThePillow(int n,int time){
        int length=n-1,offset=time%length;
        return (time/length)%2==0?1+offset:n-offset;
    }
}
