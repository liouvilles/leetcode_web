class ParkingSystem {
    int remaining[4];
    public:ParkingSystem(int big,int medium,int small):remaining{
        0,big,medium,small
    }
    {
    }
    bool addCar(int carType){
        if(!remaining[carType])return false;
        --remaining[carType];
        return true;
    }
};
