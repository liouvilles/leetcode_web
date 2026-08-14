class Solution { public boolean checkRecord(String s){int absences=0,late=0;for(char c:s.toCharArray()){if(c=='A')absences++;late=c=='L'?late+1:0;if(absences>=2||late>=3)return false;}return true;} }
