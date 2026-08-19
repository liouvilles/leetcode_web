class Encrypter {
    Map<Character,String> mapping=new HashMap<>();
    Map<String,Integer> frequency=new HashMap<>();
    public Encrypter(char[] keys,String[] values,String[] dictionary){
        for(int i=0;i<keys.length;i++)mapping.put(keys[i],values[i]);
        for(String word:dictionary){
            String encrypted=encrypt(word);
            if(!encrypted.isEmpty())frequency.merge(encrypted,1,Integer::sum);
        }
    }
    public String encrypt(String word1){
        StringBuilder result=new StringBuilder();
        for(char ch:word1.toCharArray()){
            String value=mapping.get(ch);
            if(value==null)return "";
            result.append(value);
        }
        return result.toString();
    }
    public int decrypt(String word2){
        return frequency.getOrDefault(word2,0);
    }
}
