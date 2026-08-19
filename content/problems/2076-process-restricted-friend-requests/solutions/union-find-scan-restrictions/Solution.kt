class Solution {
    private lateinit var parent:IntArray;
    private fun find(value:Int):Int{
        if(parent[value]!=value)parent[value]=find(parent[value]);
        return parent[value]
    };
    fun friendRequests(n:Int,restrictions:Array<IntArray>,requests:Array<IntArray>):BooleanArray{
        parent=IntArray(n){
            it
        };
        return BooleanArray(requests.size){
            i->val first=find(requests[i][0]);
            val second=find(requests[i][1]);
            var valid=true;
            for(restriction in restrictions){
                val a=find(restriction[0]);
                val b=find(restriction[1]);
                if(a==first&&b==second||a==second&&b==first){
                    valid=false;
                    break
                }
            };
            if(valid)parent[first]=second;
            valid
        }
    }
}
