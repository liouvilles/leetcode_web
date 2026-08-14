class RecentCounter { private val times=java.util.ArrayDeque<Int>();fun ping(t:Int):Int{times.addLast(t);while(times.first<t-3000)times.removeFirst();return times.size} }
