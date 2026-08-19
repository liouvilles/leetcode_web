class Solution {
    fun strongPasswordCheckerII(password:String):Boolean{
        if(password.length<8)return false;
        var lower=false;
        var upper=false;
        var digit=false;
        var special=false;
        val specials="!@#\$%^&*()-+";
        for(i in password.indices){
            val ch=password[i];
            if(i>0&&ch==password[i-1])return false;
            when{
                ch.isLowerCase()->lower=true;
                ch.isUpperCase()->upper=true;
                ch.isDigit()->digit=true;
                ch in specials->special=true
            }
        };
        return lower&&upper&&digit&&special
    }
}
