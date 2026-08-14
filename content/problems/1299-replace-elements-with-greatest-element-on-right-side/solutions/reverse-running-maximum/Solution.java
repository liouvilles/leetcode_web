class Solution { public int[] replaceElements(int[] arr){int maximum=-1;for(int i=arr.length-1;i>=0;i--){int original=arr[i];arr[i]=maximum;maximum=Math.max(maximum,original);}return arr;} }
