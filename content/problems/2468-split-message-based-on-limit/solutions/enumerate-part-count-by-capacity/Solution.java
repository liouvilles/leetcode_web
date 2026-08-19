class Solution {
    public String[] splitMessage(String message,int limit){
        int prefixDigits=0,totalParts=-1;
        for(int parts=1;parts<=message.length();parts++){
            prefixDigits+=String.valueOf(parts).length();
            int digits=String.valueOf(parts).length();
            long capacity=(long)parts*limit-prefixDigits-(long)parts*(3+digits);
            if(limit>3+2*digits&&capacity>=message.length()){
                totalParts=parts;
                break;
            }
        }
        if(totalParts==-1)return new String[0];
        String[] answer=new String[totalParts];
        int index=0;
        for(int part=1;part<=totalParts;part++){
            String suffix="<"+part+"/"+totalParts+">";
            int take=Math.min(limit-suffix.length(),message.length()-index);
            answer[part-1]=message.substring(index,index+take)+suffix;
            index+=take;
        }
        return answer;
    }
}
