class Solution {
    fun decodeMessage(key:String,message:String):String{
        val mapping=CharArray(26);
        var next='a';
        for(ch in key)if(ch!=' '&&mapping[ch-'a'].code==0)mapping[ch-'a']=next++;
        return buildString{
            for(ch in message)append(if(ch==' ')ch else mapping[ch-'a'])
        }
    }
}
