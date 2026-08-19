class Solution {
    public List<String> removeComments(String[] source){
        List<String> answer=new ArrayList<>();
        boolean inBlock=false;
        StringBuilder buffer=new StringBuilder();
        for(String line:source){
            for(int index=0;index<line.length();){
                if(inBlock){
                    if(index+1<line.length()&&line.charAt(index)=='*'&&line.charAt(index+1)=='/'){
                        inBlock=false;
                        index+=2;
                    }else index++;
                }else if(index+1<line.length()&&line.charAt(index)=='/'&&line.charAt(index+1)=='/')break;
                else if(index+1<line.length()&&line.charAt(index)=='/'&&line.charAt(index+1)=='*'){
                    inBlock=true;
                    index+=2;
                }else buffer.append(line.charAt(index++));
            }
            if(!inBlock&&buffer.length()>0){
                answer.add(buffer.toString());
                buffer.setLength(0);
            }
        }
        return answer;
    }
}
