package uz.coder.tezhisob.domain

import java.io.Serializable
import javax.inject.Inject

data class GameResult @Inject constructor(
    val winner:Boolean,
    val countOfRightAnswer:Int,
    val countOfQuession:Int,
    val gameSetting:GameSetting
): Serializable