class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        vector<int> answer(temperatures.size()), stack;
        for (int day = 0; day < (int)temperatures.size(); ++day) { while (!stack.empty() && temperatures[stack.back()] < temperatures[day]) { int previous = stack.back(); stack.pop_back(); answer[previous] = day - previous; } stack.push_back(day); }
        return answer;
    }
};
