package uz.coder.tezhisob.domain

import java.io.Serializable

data class GameResult(
    val winner:Boolean,
    val countOfRightAnswer:Int,
    val countOfQuession:Int,
    val gameSetting:GameSetting
): Serializable