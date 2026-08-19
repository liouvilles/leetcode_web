class Solution {
    public: string reformatNumber(string number){
        string digits;
        for(char value:number)if(isdigit(value))digits+=value;
        vector<string> groups;
        int index=0;
        while((int)digits.size()-index>4){
            groups.push_back(digits.substr(index,3));
            index+=3;
        }
        int remaining=digits.size()-index;
        if(remaining==4){
            groups.push_back(digits.substr(index,2));
            groups.push_back(digits.substr(index+2,2));
        }else groups.push_back(digits.substr(index));
        string answer;
        for(auto& group:groups){
            if(!answer.empty())answer+='-';
            answer+=group;
        }
        return answer;
    }
};
