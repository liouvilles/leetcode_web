class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> answer; int index = 0;
        while (index < (int)intervals.size() && intervals[index][1] < newInterval[0]) answer.push_back(intervals[index++]);
        while (index < (int)intervals.size() && intervals[index][0] <= newInterval[1]) { newInterval[0] = min(newInterval[0], intervals[index][0]); newInterval[1] = max(newInterval[1], intervals[index++][1]); }
        answer.push_back(newInterval); while (index < (int)intervals.size()) answer.push_back(intervals[index++]); return answer;
    }
};
