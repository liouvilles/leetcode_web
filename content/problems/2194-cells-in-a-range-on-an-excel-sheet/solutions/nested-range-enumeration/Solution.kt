class Solution { fun cellsInRange(s:String):List<String>{val answer=mutableListOf<String>();for(column in s[0]..s[3])for(row in s[1]..s[4])answer.add("$column$row");return answer} }
