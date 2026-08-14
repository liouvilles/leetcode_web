class Solution { public int partitionString(String s){int groups=1,mask=0;for(char ch:s.toCharArray()){int bit=1<<(ch-'a');if((mask&bit)!=0){groups++;mask=0;}mask|=bit;}return groups;} }
