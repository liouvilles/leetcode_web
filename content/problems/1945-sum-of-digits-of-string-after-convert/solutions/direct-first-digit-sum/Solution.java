class Solution {
    public int getLucky(String s,int k){
        int value=0;
        for(char letter:s.toCharArray()){
            int number=letter-'a'+1;
            value+=number/10+number%10;
        }
        for(int round=1;round<k;round++){
            int next=0;
            while(value>0){
                next+=value%10;
                value/=10;
            }
            value=next;
        }
        return value;
    }
}
