class Solution {
    public: int minTimeToType(string word){
        int answer=0;
        char current='a';
        for(char target:word){
            int difference=abs(target-current);
            answer+=min(difference,26-difference)+1;
            current=target;
        }
        return answer;
    }
};
