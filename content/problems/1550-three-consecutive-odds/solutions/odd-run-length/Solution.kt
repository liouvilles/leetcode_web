class Solution { fun threeConsecutiveOdds(arr:IntArray):Boolean{var consecutive=0;for(value in arr){consecutive=if(value%2!=0)consecutive+1 else 0;if(consecutive==3)return true};return false} }
