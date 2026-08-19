class Solution {
    public boolean checkIfExist(int[] arr){
        Set<Integer> seen=new HashSet<>();
        for(int value:arr){
            if(seen.contains(value*2)||value%2==0&&seen.contains(value/2))return true;
            seen.add(value);
        }
        return false;
    }
}
