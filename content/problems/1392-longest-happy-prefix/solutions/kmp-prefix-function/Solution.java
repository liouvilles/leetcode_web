class Solution {
    public String longestPrefix(String text){
        int[] prefix=new int[text.length()];
        for(int i=1;i<text.length();i++){
            int length=prefix[i-1];
            while(length>0&&text.charAt(i)!=text.charAt(length))length=prefix[length-1];
            if(text.charAt(i)==text.charAt(length))length++;
            prefix[i]=length;
        }
        return text.substring(0,prefix[text.length()-1]);
    }
}
