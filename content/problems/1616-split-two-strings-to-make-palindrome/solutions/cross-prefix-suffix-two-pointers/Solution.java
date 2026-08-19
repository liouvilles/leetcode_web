class Solution {
    private boolean palindrome(String text,int left,int right){
        while(left<right)if(text.charAt(left++)!=text.charAt(right--))return false;
        return true;
    }
    private boolean check(String first,String second){
        int left=0,right=first.length()-1;
        while(left<right&&first.charAt(left)==second.charAt(right)){
            left++;
            right--;
        }
        return palindrome(first,left,right)||palindrome(second,left,right);
    }
    public boolean checkPalindromeFormation(String a,String b){
        return check(a,b)||check(b,a);
    }
}
