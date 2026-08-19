class Solution {
    public: int countGoodRectangles(vector<vector<int>>& rectangles){
        int maximum=0,answer=0;
        for(auto& rectangle:rectangles){
            int side=min(rectangle[0],rectangle[1]);
            if(side>maximum){
                maximum=side;
                answer=1;
            }else if(side==maximum)++answer;
        }
        return answer;
    }
};
