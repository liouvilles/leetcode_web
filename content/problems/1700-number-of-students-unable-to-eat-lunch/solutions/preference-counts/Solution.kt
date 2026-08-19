class Solution {
    fun countStudents(students:IntArray,sandwiches:IntArray):Int{
        val count=IntArray(2);
        for(student in students)count[student]++;
        for(i in sandwiches.indices){
            val type=sandwiches[i];
            if(count[type]==0)return sandwiches.size-i;
            count[type]--
        };
        return 0
    }
}
