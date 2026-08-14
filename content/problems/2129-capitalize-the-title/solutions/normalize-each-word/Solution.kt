class Solution { fun capitalizeTitle(title:String):String=title.split(" ").joinToString(" "){word->val lower=word.lowercase();if(lower.length>2)lower.replaceFirstChar{it.uppercase()}else lower} }
