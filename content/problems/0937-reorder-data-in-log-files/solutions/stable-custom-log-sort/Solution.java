class Solution {
    public String[] reorderLogFiles(String[] logs){
        Arrays.sort(logs,(a,b)->{
            int sa=a.indexOf(' '),sb=b.indexOf(' ');
            boolean da=Character.isDigit(a.charAt(sa+1)),db=Character.isDigit(b.charAt(sb+1));
            if(da&&db)return 0;
            if(da!=db)return da?1:-1;
            int byContent=a.substring(sa+1).compareTo(b.substring(sb+1));
            return byContent!=0?byContent:a.substring(0,sa).compareTo(b.substring(0,sb));
        });
        return logs;
    }
}
