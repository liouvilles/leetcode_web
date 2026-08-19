class Solution {
    public: int hIndex(vector<int>& citations){
        int left=0,right=citations.size();
        while(left<right){
            int middle=left+(right-left)/2;
            if(citations[middle]>=(int)citations.size()-middle)right=middle;
            else left=middle+1;
        }
        return citations.size()-left;
    }
};
