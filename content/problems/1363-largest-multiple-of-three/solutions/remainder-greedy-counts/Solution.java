class Solution {
    private boolean remove(int[] count,int remainder,int amount){
        for(int digit=0;digit<=9&&amount>0;digit++)while(count[digit]>0&&digit%3==remainder&&amount>0){
            count[digit]--;
            amount--;
        }
        return amount==0;
    }
    public String largestMultipleOfThree(int[] digits){
        int[] count=new int[10];
        int sum=0;
        for(int digit:digits){
            count[digit]++;
            sum+=digit;
        }
        int remainder=sum%3;
        if(remainder==1&&!remove(count,1,1)&&!remove(count,2,2))return "";
        if(remainder==2&&!remove(count,2,1)&&!remove(count,1,2))return "";
        StringBuilder answer=new StringBuilder();
        for(int digit=9;digit>=0;digit--)while(count[digit]-->0)answer.append(digit);
        if(answer.length()>0&&answer.charAt(0)=='0')return "0";
        return answer.toString();
    }
}
