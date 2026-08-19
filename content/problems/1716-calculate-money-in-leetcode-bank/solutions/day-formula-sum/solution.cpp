class Solution {
    public: int totalMoney(int n){
        int answer=0;
        for(int day=0;day<n;++day)answer+=day/7+day%7+1;
        return answer;
    }
};
