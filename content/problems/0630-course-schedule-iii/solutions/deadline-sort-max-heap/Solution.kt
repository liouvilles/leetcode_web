class Solution {
    fun scheduleCourse(courses:Array<IntArray>):Int{
        courses.sortBy{
            it[1]
        };
        val durations=java.util.PriorityQueue<Int>(compareByDescending{
            it
        });
        var total=0;
        for(course in courses){
            total+=course[0];
            durations.add(course[0]);
            if(total>course[1])total-=durations.remove()
        };
        return durations.size
    }
}
