class Solution { fun findWordsContaining(words:Array<String>,x:Char):List<Int>{val answer=mutableListOf<Int>();for(index in words.indices)if(x in words[index])answer.add(index);return answer} }
