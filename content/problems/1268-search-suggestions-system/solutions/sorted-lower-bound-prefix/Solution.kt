class Solution {
    fun suggestedProducts(products:Array<String>,searchWord:String):List<List<String>>{
        products.sort();
        val answer=mutableListOf<List<String>>();
        var prefix="";
        for(ch in searchWord){
            prefix+=ch;
            var left=0;
            var right=products.size;
            while(left<right){
                val middle=(left+right)/2;
                if(products[middle]<prefix)left=middle+1 else right=middle
            };
            val suggestions=mutableListOf<String>();
            var index=left;
            while(index<products.size&&suggestions.size<3&&products[index].startsWith(prefix))suggestions.add(products[index++]);
            answer.add(suggestions)
        };
        return answer
    }
}
