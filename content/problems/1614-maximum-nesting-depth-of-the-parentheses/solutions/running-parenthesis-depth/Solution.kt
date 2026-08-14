class Solution { fun maxDepth(text:String):Int{var depth=0;var answer=0;for(value in text)if(value=='('){depth++;answer=maxOf(answer,depth)}else if(value==')')depth--;return answer} }
