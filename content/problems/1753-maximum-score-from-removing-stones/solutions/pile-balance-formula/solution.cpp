class Solution {
    public: int maximumScore(int a,int b,int c){
        int total=a+b+c,maximum=max({
            a,b,c
        });
        return min(total-maximum,total/2);
    }
};
