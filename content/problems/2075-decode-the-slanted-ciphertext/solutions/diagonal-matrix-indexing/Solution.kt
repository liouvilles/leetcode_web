class Solution {
    fun decodeCiphertext(encodedText:String,rows:Int):String{
        val cols=encodedText.length/rows;
        val answer=StringBuilder();
        for(start in 0 until cols){
            var row=0;
            var col=start;
            while(row<rows&&col<cols){
                answer.append(encodedText[row*cols+col]);
                row++;
                col++
            }
        };
        return answer.toString().trimEnd()
    }
}
