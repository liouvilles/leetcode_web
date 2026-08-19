class SQL(names:Array<String>,columns:IntArray){
    private val tables=HashMap<String,MutableList<Array<String>?>>();
    init{
        for(name in names)tables[name]=mutableListOf()
    }
    fun insertRow(name:String,row:Array<String>){
        tables[name]!!.add(row.clone())
    }
    fun deleteRow(name:String,rowId:Int){
        tables[name]!![rowId-1]=null
    }
    fun selectCell(name:String,rowId:Int,columnId:Int):String=tables[name]!![rowId-1]!![columnId-1]
}
