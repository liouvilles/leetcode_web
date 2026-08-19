class Solution {
    public boolean strongPasswordCheckerII(String password){
        if(password.length()<8)return false;
        boolean lower=false,upper=false,digit=false,special=false;
        String specials="!@#$%^&*()-+";
        for(int i=0;i<password.length();i++){
            char ch=password.charAt(i);
            if(i>0&&ch==password.charAt(i-1))return false;
            if(Character.isLowerCase(ch))lower=true;
            else if(Character.isUpperCase(ch))upper=true;
            else if(Character.isDigit(ch))digit=true;
            else if(specials.indexOf(ch)>=0)special=true;
        }
        return lower&&upper&&digit&&special;
    }
}
