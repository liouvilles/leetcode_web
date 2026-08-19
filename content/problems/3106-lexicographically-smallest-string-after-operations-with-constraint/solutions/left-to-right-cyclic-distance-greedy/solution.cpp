class Solution {
    public:string getSmallestString(string s,int k){
        for(char& letter:s){
            if(k==0)break;
            int direct=letter-'a',distance=min(direct,26-direct);
            if(distance<=k){
                letter='a';
                k-=distance;
            }else{
                letter-=k;
                k=0;
            }
        }
        return s;
    }
};
