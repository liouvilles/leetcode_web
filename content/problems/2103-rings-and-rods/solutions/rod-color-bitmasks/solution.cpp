class Solution {
    public: int countPoints(string rings){
        int mask[10]={
        };
        for(int i=0;i<(int)rings.size();i+=2){
            int bit=rings[i]=='R'?1:rings[i]=='G'?2:4;
            mask[rings[i+1]-'0']|=bit;
        }
        return count(mask,mask+10,7);
    }
};
