class Solution {
    public: bool isThree(int n){
        int root=sqrt(n);
        if(root*root!=n||root<2)return false;
        for(int divisor=2;divisor*divisor<=root;++divisor)if(root%divisor==0)return false;
        return true;
    }
};
