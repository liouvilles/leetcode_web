class Solution {
public:
    string intToRoman(int num) {
        vector<int> values = {1000,900,500,400,100,90,50,40,10,9,5,4,1}; vector<string> symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"}; string answer;
        for (int index = 0; index < (int)values.size(); ++index) while (num >= values[index]) { num -= values[index]; answer += symbols[index]; }
        return answer;
    }
};
