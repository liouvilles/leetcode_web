class Solution {
    public: int maxNumberOfFamilies(int n,vector<vector<int>>& reservedSeats){
        unordered_map<int,int> rows;
        for(auto& seat:reservedSeats)if(seat[1]>=2&&seat[1]<=9)rows[seat[0]]|=1<<seat[1];
        int left=0,middle=0,right=0;
        for(int seat=2;seat<=5;++seat)left|=1<<seat;
        for(int seat=4;seat<=7;++seat)middle|=1<<seat;
        for(int seat=6;seat<=9;++seat)right|=1<<seat;
        int answer=(n-rows.size())*2;
        for(auto [row,mask]:rows){
            bool leftFree=!(mask&left),middleFree=!(mask&middle),rightFree=!(mask&right);
            if(leftFree&&rightFree)answer+=2;
            else if(leftFree||middleFree||rightFree)++answer;
        }
        return answer;
    }
};
