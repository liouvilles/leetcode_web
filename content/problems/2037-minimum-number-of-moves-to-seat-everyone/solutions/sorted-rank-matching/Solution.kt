class Solution { fun minMovesToSeat(seats:IntArray,students:IntArray):Int{seats.sort();students.sort();return seats.indices.sumOf{kotlin.math.abs(seats[it]-students[it])}} }
