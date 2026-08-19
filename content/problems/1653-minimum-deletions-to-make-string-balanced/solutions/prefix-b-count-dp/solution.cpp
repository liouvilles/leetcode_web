class Solution {
    public: int minimumDeletions(string text){
        int bCount=0,deletions=0;
        for(char letter:text)if(letter=='b')++bCount;
        else deletions=min(deletions+1,bCount);
        return deletions;
    }
};
