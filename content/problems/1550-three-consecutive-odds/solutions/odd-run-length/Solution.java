class Solution { public boolean threeConsecutiveOdds(int[] arr){int consecutive=0;for(int value:arr){consecutive=value%2!=0?consecutive+1:0;if(consecutive==3)return true;}return false;} }
