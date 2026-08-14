class Solution { fun toLowerCase(s:String):String{val chars=s.toCharArray();for(i in chars.indices)if(chars[i] in 'A'..'Z')chars[i]=(chars[i]-'A'+'a'.code).toChar();return String(chars)} }
