class Solution { fun checkRecord(s:String):Boolean{var absences=0;var late=0;for(c in s){if(c=='A')absences++;late=if(c=='L')late+1 else 0;if(absences>=2||late>=3)return false};return true} }
