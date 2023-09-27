package uz.coder.tezhisob.domain

data class Question(
    val yigindi:Int,
    val visableNumber:Int,
    val options:List<Int>
){
 val rightAnswer = yigindi-visableNumber
}
