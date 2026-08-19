class Solution {
    public: vector<int> canSeePersonsCount(vector<int>& heights){
        vector<int> answer(heights.size()),stack;
        for(int i=heights.size()-1;i>=0;--i){
            while(!stack.empty()&&stack.back()<heights[i]){
                stack.pop_back();
                ++answer[i];
            }
            if(!stack.empty())++answer[i];
            stack.push_back(heights[i]);
        }
        return answer;
    }
};
