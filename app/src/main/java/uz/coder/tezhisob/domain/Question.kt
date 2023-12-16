package uz.coder.tezhisob.domain

import javax.inject.Inject

data class Question @Inject constructor(
    val yigindi:Int,
    val visableNumber:Int,
    val options:List<Int>
){
 val rightAnswer = yigindi-visableNumber
}
