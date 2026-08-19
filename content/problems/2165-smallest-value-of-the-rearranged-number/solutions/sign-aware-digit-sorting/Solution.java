class Solution {
    public long smallestNumber(long num){
        if(num==0)return 0;
        char[] digits=Long.toString(Math.abs(num)).toCharArray();
        Arrays.sort(digits);
        if(num>0){
            int first=0;
            while(digits[first]=='0')first++;
            char temporary=digits[0];
            digits[0]=digits[first];
            digits[first]=temporary;
            return Long.parseLong(new String(digits));
        }
        for(int left=0,right=digits.length-1;left<right;left++,right--){
            char temporary=digits[left];
            digits[left]=digits[right];
            digits[right]=temporary;
        }
        return -Long.parseLong(new String(digits));
    }
}
