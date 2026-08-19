class Solution {
    public int sumOfEncryptedInt(int[] nums){
        int answer=0;
        for(int number:nums){
            int value=number,maximum=0,place=0;
            while(value>0){
                maximum=Math.max(maximum,value%10);
                place=place*10+1;
                value/=10;
            }
            answer+=maximum*place;
        }
        return answer;
    }
}
