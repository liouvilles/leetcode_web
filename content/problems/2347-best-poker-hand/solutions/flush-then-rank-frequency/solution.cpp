class Solution {
    public:string bestHand(vector<int>& ranks,vector<char>& suits){
        if(all_of(suits.begin(),suits.end(),[&](char suit){
            return suit==suits[0];
        }))return "Flush";
        int frequency[14]={
        },maximum=0;
        for(int rank:ranks)maximum=max(maximum,++frequency[rank]);
        if(maximum>=3)return "Three of a Kind";
        if(maximum>=2)return "Pair";
        return "High Card";
    }
};
