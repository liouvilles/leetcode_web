class Solution { fun average(salary:IntArray):Double=(salary.sum()-salary.minOrNull()!!-salary.maxOrNull()!!)/(salary.size-2.0) }
