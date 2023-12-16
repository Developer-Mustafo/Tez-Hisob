package uz.coder.tezhisob.domain

import javax.inject.Inject

data class GameSetting @Inject constructor(
    val maxSumValue:Int,
    val minCountOfRightAnswer:Int,
    val minPercentOfRightAnswer:Int,
    val timer:Int
)
