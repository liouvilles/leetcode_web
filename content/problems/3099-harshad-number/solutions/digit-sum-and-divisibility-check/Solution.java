class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x){
        int original=x,digitSum=0;
        while(x>0){
            digitSum+=x%10;
            x/=10;
        }
        return original%digitSum==0?digitSum:-1;
    }
}
