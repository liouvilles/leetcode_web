class Solution {
    public List<List<String>> suggestedProducts(String[] products,String searchWord){
        Arrays.sort(products);
        List<List<String>> answer=new ArrayList<>();
        StringBuilder prefix=new StringBuilder();
        for(char ch:searchWord.toCharArray()){
            prefix.append(ch);
            int left=0,right=products.length;
            while(left<right){
                int middle=(left+right)/2;
                if(products[middle].compareTo(prefix.toString())<0)left=middle+1;
                else right=middle;
            }
            List<String> suggestions=new ArrayList<>();
            for(int i=left;i<products.length&&suggestions.size()<3&&products[i].startsWith(prefix.toString());i++)suggestions.add(products[i]);
            answer.add(suggestions);
        }
        return answer;
    }
}
