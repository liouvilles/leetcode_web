class Solution { public: int numJewelsInStones(string jewels,string stones){bool set[128]{};for(char c:jewels)set[(int)c]=true;int answer=0;for(char c:stones)answer+=set[(int)c];return answer;} };
