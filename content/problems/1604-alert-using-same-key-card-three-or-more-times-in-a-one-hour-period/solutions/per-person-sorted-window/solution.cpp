class Solution {
    public: vector<string> alertNames(vector<string>& keyName,vector<string>& keyTime){
        unordered_map<string,vector<int>> times;
        for(int i=0;i<(int)keyName.size();++i)times[keyName[i]].push_back(stoi(keyTime[i].substr(0,2))*60+stoi(keyTime[i].substr(3)));
        vector<string> answer;
        for(auto& [name,values]:times){
            sort(values.begin(),values.end());
            for(int i=0;i+2<(int)values.size();++i)if(values[i+2]-values[i]<=60){
                answer.push_back(name);
                break;
            }
        }
        sort(answer.begin(),answer.end());
        return answer;
    }
};
