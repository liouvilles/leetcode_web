class Solution {
    fun minimumEffort(tasks:Array<IntArray>):Int{
        tasks.sortWith(compareByDescending{
            it[1]-it[0]
        });
        var required=0;
        var spent=0;
        for(task in tasks){
            required=maxOf(required,spent+task[1]);
            spent+=task[0]
        };
        return required
    }
}
