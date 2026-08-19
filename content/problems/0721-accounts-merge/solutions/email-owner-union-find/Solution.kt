class Solution {
    private lateinit var parent:IntArray;
    private fun find(value:Int):Int{
        if(parent[value]!=value)parent[value]=find(parent[value]);
        return parent[value]
    };
    private fun union(a:Int,b:Int){
        parent[find(a)]=find(b)
    };
    fun accountsMerge(accounts:List<List<String>>):List<List<String>>{
        parent=IntArray(accounts.size){
            it
        };
        val owner=hashMapOf<String,Int>();
        val names=hashMapOf<String,String>();
        for(i in accounts.indices)for(j in 1 until accounts[i].size){
            val email=accounts[i][j];
            names[email]=accounts[i][0];
            if(email in owner)union(i,owner[email]!!) else owner[email]=i
        };
        val groups=hashMapOf<Int,MutableList<String>>();
        for((email,index) in owner)groups.getOrPut(find(index)){
            mutableListOf()
        }.add(email);
        return groups.values.map{
            emails->emails.sort();
            listOf(names[emails[0]]!!)+emails
        }.sortedBy{
            it[1]
        }
    }
}
