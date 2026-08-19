class Robot {
    int width,height,perimeter,progress=0;
    bool moved=false;
    public: Robot(int width,int height):width(width),height(height),perimeter(2*(width+height)-4){
    }
    void step(int num){
        progress=(progress+num%perimeter)%perimeter;
        moved=true;
    }
    vector<int> getPos(){
        int east=width-1,north=east+height-1,west=north+width-1;
        if(progress<=east)return{
            progress,0
        };
        if(progress<=north)return{
            width-1,progress-east
        };
        if(progress<=west)return{
            width-1-(progress-north),height-1
        };
        return{
            0,height-1-(progress-west)
        };
    }
    string getDir(){
        int east=width-1,north=east+height-1,west=north+width-1;
        if(!progress)return moved?"South":"East";
        if(progress<=east)return"East";
        if(progress<=north)return"North";
        if(progress<=west)return"West";
        return"South";
    }
};
