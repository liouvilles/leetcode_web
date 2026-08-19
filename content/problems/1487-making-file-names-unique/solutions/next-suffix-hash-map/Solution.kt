class Solution {
    fun getFolderNames(names:Array<String>):Array<String>{
        val next=mutableMapOf<String,Int>();
        return Array(names.size){
            i->val name=names[i];
            if(name !in next){
                next[name]=1;
                name
            }else{
                var k=next.getValue(name);
                var candidate="$name($k)";
                while(candidate in next){
                    k++;
                    candidate="$name($k)"
                };
                next[name]=k+1;
                next[candidate]=1;
                candidate
            }
        }
    }
}
