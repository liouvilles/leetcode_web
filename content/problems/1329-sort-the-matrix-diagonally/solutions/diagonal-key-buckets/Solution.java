class Solution {
    public int[][] diagonalSort(int[][] mat){
        Map<Integer,List<Integer>> groups=new HashMap<>();
        for(int r=0;r<mat.length;r++)for(int c=0;c<mat[0].length;c++)groups.computeIfAbsent(r-c,key->new ArrayList<>()).add(mat[r][c]);
        for(List<Integer> values:groups.values())Collections.sort(values);
        Map<Integer,Integer> index=new HashMap<>();
        for(int r=0;r<mat.length;r++)for(int c=0;c<mat[0].length;c++){
            int key=r-c,position=index.getOrDefault(key,0);
            mat[r][c]=groups.get(key).get(position);
            index.put(key,position+1);
        }
        return mat;
    }
}
