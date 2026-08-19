class Solution {
    public: bool isLongPressedName(string name,string typed){
        int i=0;
        for(int j=0;j<(int)typed.size();++j){
            if(i<(int)name.size()&&typed[j]==name[i])++i;
            else if(j==0||typed[j]!=typed[j-1])return false;
        }
        return i==(int)name.size();
    }
};
