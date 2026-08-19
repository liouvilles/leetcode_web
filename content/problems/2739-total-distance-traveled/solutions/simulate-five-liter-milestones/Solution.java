class Solution {
    public int distanceTraveled(int mainTank,int additionalTank){
        int distance=0;
        while(mainTank>=5&&additionalTank>0){
            mainTank-=5;
            distance+=50;
            mainTank++;
            additionalTank--;
        }
        return distance+mainTank*10;
    }
}
