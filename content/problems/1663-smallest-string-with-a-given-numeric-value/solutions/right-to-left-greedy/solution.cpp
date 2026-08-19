class Solution {
    public: string getSmallestString(int n,int k){
        string letters(n,'a');
        int remaining=k-n;
        for(int index=n-1;index>=0&&remaining;--index){
            int add=min(25,remaining);
            letters[index]+=add;
            remaining-=add;
        }
        return letters;
    }
};
