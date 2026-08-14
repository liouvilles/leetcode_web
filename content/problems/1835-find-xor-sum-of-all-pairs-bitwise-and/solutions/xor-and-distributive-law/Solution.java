class Solution { public int getXORSum(int[] arr1,int[] arr2){int first=0,second=0;for(int value:arr1)first^=value;for(int value:arr2)second^=value;return first&second;} }
