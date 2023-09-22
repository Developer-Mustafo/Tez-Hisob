package uz.coder.tezhisob.data

import uz.coder.tezhisob.domain.GameRepository
import uz.coder.tezhisob.domain.GameSetting
import uz.coder.tezhisob.domain.Level
import uz.coder.tezhisob.domain.Quession
import java.lang.Integer.max
import java.lang.Integer.min
import kotlin.random.Random

object GameRepositoryImpl:GameRepository {
    private const val MIN_SUM_VALUE = 2
    private const val MIN_SUM_VALUE_ANSWER = 1
    override fun genereteQuession(maxSumValue: Int, countOfOptions: Int): Quession {
        val yigindi = Random.nextInt(MIN_SUM_VALUE_ANSWER, maxSumValue)
        val visibilityNumber = Random.nextInt(MIN_SUM_VALUE, maxSumValue)
        val rightAnswer = yigindi - visibilityNumber
        val variant = HashSet<Int>()
        variant.add(rightAnswer)
        val from = max(rightAnswer - maxSumValue, MIN_SUM_VALUE_ANSWER)
        val to = min(maxSumValue - 1, rightAnswer + countOfOptions)
        while (variant.size < countOfOptions) {
            variant.add(Random.nextInt(from, to))
        }
        return Quession(yigindi, visibilityNumber, variant.toList())
    }

    override fun getGameSetting(level: Level): GameSetting = when (level) {
        Level.TEST -> GameSetting(10, 5, 50, 8)
        Level.EASY -> GameSetting(10, 10, 70, 60)
        Level.NORMAL -> GameSetting(20, 20, 80, 40)
        Level.HARD -> GameSetting(30, 30, 90, 45)
    }
}