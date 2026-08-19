class Solution {
    public: string addStrings(string num1,string num2){
        string answer;
        int i=num1.size()-1,j=num2.size()-1,carry=0;
        while(i>=0||j>=0||carry){
            int sum=carry+(i>=0?num1[i--]-'0':0)+(j>=0?num2[j--]-'0':0);
            answer+=char('0'+sum%10);
            carry=sum/10;
        }
        reverse(answer.begin(),answer.end());
        return answer;
    }
};
