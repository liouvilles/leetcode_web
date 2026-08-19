class Solution {
    private boolean valid(char[] value,int index,char candidate){
        return index<1||value[index-1]!=candidate&& (index<2||value[index-2]!=candidate);
    }
    public String smallestBeautifulString(String s,int k){
        char[] value=s.toCharArray();
        char limit=(char)('a'+k);
        for(int index=value.length-1;index>=0;index--){
            for(char candidate=(char)(value[index]+1);candidate<limit;candidate++)if(valid(value,index,candidate)){
                value[index]=candidate;
                for(int next=index+1;next<value.length;next++)for(char fill='a';fill<limit;fill++)if(valid(value,next,fill)){
                    value[next]=fill;
                    break;
                }
                return new String(value);
            }
        }
        return "";
    }
}
