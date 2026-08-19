class Solution {
    public: int minFlips(string target){
        char current='0';
        int answer=0;
        for(char value:target)if(value!=current){
            ++answer;
            current=value;
        }
        return answer;
    }
};
