class Solution {
    fun categorizeBox(length:Int,width:Int,height:Int,mass:Int):String{
        val bulky=length>=10000||width>=10000||height>=10000||length.toLong()*width*height>=1_000_000_000L;
        val heavy=mass>=100;
        return if(bulky&&heavy)"Both" else if(bulky)"Bulky" else if(heavy)"Heavy" else "Neither"
    }
}
