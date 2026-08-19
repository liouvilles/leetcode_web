class Solution {
    public String discountPrices(String sentence,int discount){
        String[] words=sentence.split(" ");
        for(int i=0;i<words.length;i++){
            String word=words[i];
            boolean valid=word.length()>1&&word.charAt(0)=='$';
            for(int j=1;j<word.length()&&valid;j++)valid=Character.isDigit(word.charAt(j));
            if(valid){
                long price=Long.parseLong(word.substring(1));
                words[i]=String.format(Locale.US,"$%.2f",price*(100-discount)/100.0);
            }
        }
        return String.join(" ",words);
    }
}
