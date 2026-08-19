class Solution {
    public String maximumBinaryString(String binary){
        int first=binary.indexOf('0');
        if(first<0)return binary;
        int zeros=0;
        for(char bit:binary.toCharArray())if(bit=='0')zeros++;
        char[] answer=new char[binary.length()];
        Arrays.fill(answer,'1');
        answer[first+zeros-1]='0';
        return new String(answer);
    }
}
