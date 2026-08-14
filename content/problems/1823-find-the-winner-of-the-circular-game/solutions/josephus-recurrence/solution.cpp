class Solution { public: int findTheWinner(int n,int k){int winner=0;for(int size=1;size<=n;++size)winner=(winner+k)%size;return winner+1;} };
