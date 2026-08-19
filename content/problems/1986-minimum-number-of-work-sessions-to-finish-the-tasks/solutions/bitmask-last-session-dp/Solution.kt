class Solution {
    fun minSessions(tasks:IntArray,sessionTime:Int):Int{
        val total=1 shl tasks.size;
        val sessions=IntArray(total){
            100
        };
        val used=IntArray(total);
        sessions[0]=1;
        for(mask in 0 until total)for(task in tasks.indices)if(mask and (1 shl task)==0){
            val next=mask or (1 shl task);
            var newSessions=sessions[mask];
            var newUsed=used[mask]+tasks[task];
            if(newUsed>sessionTime){
                newSessions++;
                newUsed=tasks[task]
            };
            if(newSessions<sessions[next]||newSessions==sessions[next]&&newUsed<used[next]){
                sessions[next]=newSessions;
                used[next]=newUsed
            }
        };
        return sessions.last()
    }
}
