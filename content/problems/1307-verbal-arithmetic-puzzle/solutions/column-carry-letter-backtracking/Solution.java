class Solution {
    private String[] words;
    private String result;
    private int[] mapping=new int[26];
    private boolean[] used=new boolean[10],leading=new boolean[26];
    public boolean isSolvable(String[] words,String result){
        this.words=words;
        this.result=result;
        Arrays.fill(mapping,-1);
        for(String word:words){
            if(word.length()>result.length())return false;
            if(word.length()>1)leading[word.charAt(0)-'A']=true;
        }
        if(result.length()>1)leading[result.charAt(0)-'A']=true;
        return dfs(0,0,0);
    }
    private boolean dfs(int column,int row,int sum){
        if(column==result.length())return sum==0;
        if(row<words.length){
            String word=words[row];
            int index=word.length()-1-column;
            if(index<0)return dfs(column,row+1,sum);
            int letter=word.charAt(index)-'A';
            if(mapping[letter]>=0)return dfs(column,row+1,sum+mapping[letter]);
            for(int digit=0;digit<=9;digit++)if(!used[digit]&&(digit!=0||!leading[letter])){
                mapping[letter]=digit;
                used[digit]=true;
                if(dfs(column,row+1,sum+digit))return true;
                used[digit]=false;
                mapping[letter]=-1;
            }
            return false;
        }
        int letter=result.charAt(result.length()-1-column)-'A',digit=sum%10,carry=sum/10;
        if(mapping[letter]>=0)return mapping[letter]==digit&&dfs(column+1,0,carry);
        if(used[digit]||digit==0&&leading[letter])return false;
        mapping[letter]=digit;
        used[digit]=true;
        boolean solved=dfs(column+1,0,carry);
        used[digit]=false;
        mapping[letter]=-1;
        return solved;
    }
}
