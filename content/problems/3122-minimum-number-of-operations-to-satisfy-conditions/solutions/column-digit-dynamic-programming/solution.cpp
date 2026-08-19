class Solution {
    public:int minimumOperations(vector<vector<int>>& grid){
        int rows=grid.size(),cols=grid[0].size();
        array<int,10> count{
        };
        for(int row=0;row<rows;++row)++count[grid[row][0]];
        array<int,10> previous;
        for(int digit=0;digit<10;++digit)previous[digit]=rows-count[digit];
        for(int col=1;col<cols;++col){
            count.fill(0);
            for(int row=0;row<rows;++row)++count[grid[row][col]];
            array<int,10> current;
            for(int digit=0;digit<10;++digit){
                int best=INT_MAX;
                for(int previousDigit=0;previousDigit<10;++previousDigit)if(previousDigit!=digit)best=min(best,previous[previousDigit]);
                current[digit]=best+rows-count[digit];
            }
            previous=current;
        }
        return *min_element(previous.begin(),previous.end());
    }
};
