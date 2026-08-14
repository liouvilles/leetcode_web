class Solution { fun countSegments(s:String):Int{var count=0;for(i in s.indices)if(s[i]!=' '&&(i==0||s[i-1]==' '))count++;return count} }
