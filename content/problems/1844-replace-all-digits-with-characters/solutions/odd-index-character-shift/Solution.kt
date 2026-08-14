class Solution { fun replaceDigits(text:String):String{val chars=text.toCharArray();for(i in 1 until chars.size step 2)chars[i]=(chars[i-1].code+(chars[i]-'0')).toChar();return String(chars)} }
