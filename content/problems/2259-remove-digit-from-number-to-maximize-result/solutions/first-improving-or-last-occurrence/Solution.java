class Solution {
    public String removeDigit(String number,char digit){
        int remove=number.lastIndexOf(digit);
        for(int i=0;i+1<number.length();i++)if(number.charAt(i)==digit&&number.charAt(i+1)>digit){
            remove=i;
            break;
        }
        return number.substring(0,remove)+number.substring(remove+1);
    }
}
