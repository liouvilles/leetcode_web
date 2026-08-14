class Solution { fun mostWordsFound(sentences:Array<String>):Int=sentences.maxOf{sentence->1+sentence.count{it==' '}} }
