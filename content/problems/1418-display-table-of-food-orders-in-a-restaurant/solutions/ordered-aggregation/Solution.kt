class Solution {
    fun displayTable(orders:List<List<String>>):List<List<String>>{
        val foods=java.util.TreeSet<String>();
        val tables=java.util.TreeMap<Int,MutableMap<String,Int>>();
        for(order in orders){
            val table=order[1].toInt();
            val food=order[2];
            foods.add(food);
            val count=tables.getOrPut(table){
                mutableMapOf()
            };
            count[food]=(count[food]?:0)+1
        };
        val answer=mutableListOf<List<String>>();
        answer.add(listOf("Table")+foods);
        for((table,count)in tables)answer.add(listOf(table.toString())+foods.map{
            (count[it]?:0).toString()
        });
        return answer
    }
}
