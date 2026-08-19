class Solution {
    public: int twoEggDrop(int n){
        int moves=0,covered=0;
        while(covered<n)covered+=++moves;
        return moves;
    }
};
