class Solution { public int[][] sortTheStudents(int[][] score,int k){Arrays.sort(score,(first,second)->Integer.compare(second[k],first[k]));return score;} }
