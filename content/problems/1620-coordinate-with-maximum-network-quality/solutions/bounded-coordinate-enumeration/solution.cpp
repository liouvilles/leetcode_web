class Solution {
    public: vector<int> bestCoordinate(vector<vector<int>>& towers,int radius){
        int best=-1,bestX=0,bestY=0;
        for(int x=0;x<=50;++x)for(int y=0;y<=50;++y){
            int quality=0;
            for(auto& tower:towers){
                int dx=x-tower[0],dy=y-tower[1];
                double distance=sqrt(dx*dx+dy*dy);
                if(distance<=radius)quality+=(int)(tower[2]/(1+distance));
            }
            if(quality>best){
                best=quality;
                bestX=x;
                bestY=y;
            }
        }
        return {
            bestX,bestY
        };
    }
};
