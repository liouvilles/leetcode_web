class Solution {
    fun distanceTraveled(mainTank:Int,additionalTank:Int):Int{
        var main=mainTank;
        var extra=additionalTank;
        var distance=0;
        while(main>=5&&extra>0){
            main-=5;
            distance+=50;
            main++;
            extra--
        };
        return distance+main*10
    }
}
