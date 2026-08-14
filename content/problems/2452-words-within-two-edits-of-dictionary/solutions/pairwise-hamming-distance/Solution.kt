class Solution { fun twoEditWords(queries:Array<String>,dictionary:Array<String>):List<String>{return queries.filter{query->dictionary.any{word->query.indices.count{query[it]!=word[it]}<=2}}} }
