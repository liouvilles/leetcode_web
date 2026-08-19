class Solution {
    public: vector<int> corpFlightBookings(vector<vector<int>>& bookings,int n){
        vector<int> difference(n+1);
        for(auto& booking:bookings){
            difference[booking[0]-1]+=booking[2];
            difference[booking[1]]-=booking[2];
        }
        vector<int> answer(n);
        int running=0;
        for(int i=0;i<n;++i)answer[i]=running+=difference[i];
        return answer;
    }
};
