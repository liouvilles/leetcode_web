class Solution {
    long long apples(long long side){
        return 2*side*(side+1)*(2*side+1);
    }
    public: long long minimumPerimeter(long long neededApples){
        long long left=1,right=1;
        while(apples(right)<neededApples)right*=2;
        while(left<right){
            long long middle=(left+right)/2;
            if(apples(middle)>=neededApples)right=middle;
            else left=middle+1;
        }
        return 8*left;
    }
};
