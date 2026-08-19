class Solution {
    public int largestInteger(int num){
        char[] digits=Integer.toString(num).toCharArray();
        List<Character> odd=new ArrayList<>(),even=new ArrayList<>();
        for(char digit:digits)(digit%2==0?even:odd).add(digit);
        odd.sort(Collections.reverseOrder());
        even.sort(Collections.reverseOrder());
        int o=0,e=0;
        for(int i=0;i<digits.length;i++)digits[i]=digits[i]%2==0?even.get(e++):odd.get(o++);
        return Integer.parseInt(new String(digits));
    }
}
