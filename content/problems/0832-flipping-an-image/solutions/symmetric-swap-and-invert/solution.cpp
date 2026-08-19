class Solution {
    public: vector<vector<int>> flipAndInvertImage(vector<vector<int>>& image){
        for(auto& row:image)for(int left=0,right=row.size()-1;left<=right;++left,--right){
            int first=row[left],second=row[right];
            row[left]=second^1;
            row[right]=first^1;
        }
        return image;
    }
};
