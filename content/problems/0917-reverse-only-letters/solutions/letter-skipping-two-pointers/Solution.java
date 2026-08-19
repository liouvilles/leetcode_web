class Solution {
    public String reverseOnlyLetters(String s){
        char[] chars=s.toCharArray();
        int left=0,right=chars.length-1;
        while(left<right){
            if(!Character.isLetter(chars[left]))left++;
            else if(!Character.isLetter(chars[right]))right--;
            else{
                char temporary=chars[left];
                chars[left++]=chars[right];
                chars[right--]=temporary;
            }
        }
        return new String(chars);
    }
}
