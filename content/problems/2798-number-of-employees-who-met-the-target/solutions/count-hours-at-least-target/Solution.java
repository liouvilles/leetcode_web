class Solution { public int numberOfEmployeesWhoMetTarget(int[] hours,int target){int answer=0;for(int value:hours)if(value>=target)answer++;return answer;} }
