class Solution {
    public: bool isOneBitCharacter(vector<int>& bits){
        int index=0;
        while(index<(int)bits.size()-1)index+=bits[index]==0?1:2;
        return index==(int)bits.size()-1;
    }
};
