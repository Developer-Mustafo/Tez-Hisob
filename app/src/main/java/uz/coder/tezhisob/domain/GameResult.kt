package uz.coder.tezhisob.domain

data class GameResult(
    val winner:Boolean,
    val countOfRightAnswer:Int,
    val countOfQuession:Int,
    val gameSetting:GameSetting
)