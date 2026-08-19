class Solution {
    public: int lastRemaining(int n){
        int head=1,step=1,remaining=n;
        bool left=true;
        while(remaining>1){
            if(left||(remaining&1))head+=step;
            remaining/=2;
            step*=2;
            left=!left;
        }
        return head;
    }
};
