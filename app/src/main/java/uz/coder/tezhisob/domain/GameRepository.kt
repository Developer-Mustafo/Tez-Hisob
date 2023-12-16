package uz.coder.tezhisob.domain

interface GameRepository {
    fun genereteQuession(maxSumValue:Int,countOfOptions:Int):Question
    fun getGameSetting(string: String):GameSetting
}