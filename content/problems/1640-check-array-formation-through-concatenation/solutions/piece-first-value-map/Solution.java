class Solution {
    public boolean canFormArray(int[] arr,int[][] pieces){
        Map<Integer,int[]> byFirst=new HashMap<>();
        for(int[] piece:pieces)byFirst.put(piece[0],piece);
        int index=0;
        while(index<arr.length){
            int[] piece=byFirst.get(arr[index]);
            if(piece==null)return false;
            for(int value:piece)if(index>=arr.length||arr[index++]!=value)return false;
        }
        return true;
    }
}
