class Solution {
    public:string categorizeBox(int length,int width,int height,int mass){
        bool bulky=length>=10000||width>=10000||height>=10000||1LL*length*width*height>=1'000'000'000;
        bool heavy=mass>=100;
        if(bulky&&heavy)return "Both";
        if(bulky)return "Bulky";
        if(heavy)return "Heavy";
        return "Neither";
    }
};
