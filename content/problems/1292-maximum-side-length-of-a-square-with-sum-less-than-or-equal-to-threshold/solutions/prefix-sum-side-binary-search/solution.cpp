class Solution {
    public: int maxSideLength(vector<vector<int>>& mat,int threshold){
        int rows=mat.size(),columns=mat[0].size();
        vector<vector<int>> prefix(rows+1,vector<int>(columns+1));
        for(int r=0;r<rows;++r)for(int c=0;c<columns;++c)prefix[r+1][c+1]=mat[r][c]+prefix[r][c+1]+prefix[r+1][c]-prefix[r][c];
        auto feasible=[&](int side){
            for(int r=side;r<=rows;++r)for(int c=side;c<=columns;++c)if(prefix[r][c]-prefix[r-side][c]-prefix[r][c-side]+prefix[r-side][c-side]<=threshold)return true;
            return false;
        };
        int left=0,right=min(rows,columns);
        while(left<right){
            int middle=(left+right+1)/2;
            if(feasible(middle))left=middle;
            else right=middle-1;
        }
        return left;
    }
};
