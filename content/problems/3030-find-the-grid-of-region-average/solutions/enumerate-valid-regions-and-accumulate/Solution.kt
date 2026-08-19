class Solution {
    fun resultGrid(image:Array<IntArray>,threshold:Int):Array<IntArray>{
        val rows=image.size;
        val columns=image[0].size;
        val sum=Array(rows){
            IntArray(columns)
        };
        val count=Array(rows){
            IntArray(columns)
        };
        for(top in 0 until rows-2)for(left in 0 until columns-2){
            var valid=true;
            loop@for(row in top..top+2)for(column in left until left+2)if(kotlin.math.abs(image[row][column]-image[row][column+1])>threshold){
                valid=false;
                break@loop
            };
            if(valid)loop@for(row in top until top+2)for(column in left..left+2)if(kotlin.math.abs(image[row][column]-image[row+1][column])>threshold){
                valid=false;
                break@loop
            };
            if(!valid)continue;
            var average=0;
            for(row in top..top+2)for(column in left..left+2)average+=image[row][column];
            average/=9;
            for(row in top..top+2)for(column in left..left+2){
                sum[row][column]+=average;
                count[row][column]++
            }
        };
        return Array(rows){
            row->IntArray(columns){
                column->if(count[row][column]==0)image[row][column] else sum[row][column]/count[row][column]
            }
        }
    }
}
