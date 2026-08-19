class ParkingSystem {
    private final int[] remaining=new int[4];
    public ParkingSystem(int big,int medium,int small){
        remaining[1]=big;
        remaining[2]=medium;
        remaining[3]=small;
    }
    public boolean addCar(int carType){
        if(remaining[carType]==0)return false;
        remaining[carType]--;
        return true;
    }
}
