class Solution { public int[][] kClosest(int[][] points,int k){Arrays.sort(points,Comparator.comparingLong(p->(long)p[0]*p[0]+(long)p[1]*p[1]));return Arrays.copyOf(points,k);} }
