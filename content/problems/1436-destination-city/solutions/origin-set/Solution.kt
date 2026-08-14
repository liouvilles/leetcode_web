class Solution { fun destCity(paths:List<List<String>>):String{val origins=paths.map{it[0]}.toSet();return paths.first{it[1] !in origins}[1]} }
