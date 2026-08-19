class Solution {
    public String thousandSeparator(int n){
        String text=String.valueOf(n);
        StringBuilder reversed=new StringBuilder();
        int count=0;
        for(int i=text.length()-1;i>=0;i--){
            reversed.append(text.charAt(i));
            if(++count%3==0&&i>0)reversed.append('.');
        }
        return reversed.reverse().toString();
    }
}
