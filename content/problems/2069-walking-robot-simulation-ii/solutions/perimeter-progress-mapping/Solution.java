class Robot {
    int width,height,perimeter,progress;
    boolean moved;
    public Robot(int width,int height){
        this.width=width;
        this.height=height;
        perimeter=2*(width+height)-4;
    }
    public void step(int num){
        progress=(progress+num%perimeter)%perimeter;
        moved=true;
    }
    public int[] getPos(){
        int east=width-1,north=east+height-1,west=north+width-1;
        if(progress<=east)return new int[]{
            progress,0
        };
        if(progress<=north)return new int[]{
            width-1,progress-east
        };
        if(progress<=west)return new int[]{
            width-1-(progress-north),height-1
        };
        return new int[]{
            0,height-1-(progress-west)
        };
    }
    public String getDir(){
        int east=width-1,north=east+height-1,west=north+width-1;
        if(progress==0)return moved?"South":"East";
        if(progress<=east)return "East";
        if(progress<=north)return "North";
        if(progress<=west)return "West";
        return "South";
    }
}
