class Solution {
    fun largestWordCount(messages:Array<String>,senders:Array<String>):String{
        val count=HashMap<String,Int>();
        for(i in messages.indices)count[senders[i]]=(count[senders[i]]?:0)+messages[i].count{
            it==' '
        }+1;
        var answer="";
        var best=-1;
        for((sender,total) in count)if(total>best||total==best&&sender>answer){
            best=total;
            answer=sender
        };
        return answer
    }
}
