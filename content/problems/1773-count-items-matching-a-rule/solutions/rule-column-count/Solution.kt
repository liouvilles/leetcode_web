class Solution { fun countMatches(items:List<List<String>>,ruleKey:String,ruleValue:String):Int{val index=when(ruleKey){"type"->0;"color"->1;else->2};return items.count{it[index]==ruleValue}} }
