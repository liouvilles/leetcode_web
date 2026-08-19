class Solution {
    public:vector<string> findAllRecipes(vector<string>& recipes,vector<vector<string>>& ingredients,vector<string>& supplies){
        unordered_map<string,vector<int>> dependents;
        vector<int> missing(recipes.size());
        for(int i=0;i<(int)recipes.size();++i){
            missing[i]=ingredients[i].size();
            for(string& ingredient:ingredients[i])dependents[ingredient].push_back(i);
        }
        queue<string> available;
        for(string& supply:supplies)available.push(supply);
        vector<string> answer;
        while(!available.empty()){
            string item=available.front();
            available.pop();
            for(int recipe:dependents[item])if(!--missing[recipe]){
                answer.push_back(recipes[recipe]);
                available.push(recipes[recipe]);
            }
        }
        return answer;
    }
};
