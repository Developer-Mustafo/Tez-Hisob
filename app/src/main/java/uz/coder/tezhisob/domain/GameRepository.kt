package uz.coder.tezhisob.domain

interface GameRepository {
    fun genereteQuession(maxSumValue:Int,countOfOptions:Int):Quession
    fun getGameSetting(level: Level):GameSetting
}