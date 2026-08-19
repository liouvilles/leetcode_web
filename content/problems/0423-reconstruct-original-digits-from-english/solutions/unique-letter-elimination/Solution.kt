class Solution {
    fun originalDigits(s:String):String{
        val letters=IntArray(26);
        val count=IntArray(10);
        for(c in s)letters[c-'a']++;
        count[0]=letters['z'-'a'];
        count[2]=letters['w'-'a'];
        count[4]=letters['u'-'a'];
        count[6]=letters['x'-'a'];
        count[8]=letters['g'-'a'];
        count[3]=letters['h'-'a']-count[8];
        count[5]=letters['f'-'a']-count[4];
        count[7]=letters['s'-'a']-count[6];
        count[1]=letters['o'-'a']-count[0]-count[2]-count[4];
        count[9]=letters['i'-'a']-count[5]-count[6]-count[8];
        val answer=StringBuilder();
        for(digit in 0..9)repeat(count[digit]){
            answer.append(digit)
        };
        return answer.toString()
    }
}
