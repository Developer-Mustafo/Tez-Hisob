package uz.coder.tezhisob.data

import uz.coder.tezhisob.domain.GameRepository
import uz.coder.tezhisob.domain.GameSetting
import uz.coder.tezhisob.domain.Level
import uz.coder.tezhisob.domain.Question
import java.lang.Integer.max
import java.lang.Integer.min
import kotlin.random.Random

object GameRepositoryImpl:GameRepository {
    private const val MIN_SUM_VALUE = 2
    private const val MIN_SUM_VALUE_ANSWER = 1
    override fun genereteQuession(maxSumValue: Int, countOfOptions: Int): Question {
        val yigindi = Random.nextInt(MIN_SUM_VALUE, maxSumValue+1) //27
        val visibleNumber = Random.nextInt(MIN_SUM_VALUE_ANSWER, yigindi) //15
        val variantlar = HashSet<Int>()
        val rightAnswer = yigindi - visibleNumber
        variantlar.add(rightAnswer)
        val from = kotlin.math.max(rightAnswer - countOfOptions, MIN_SUM_VALUE)//1
        val to = kotlin.math.min(maxSumValue - 1, rightAnswer + countOfOptions)
        while (variantlar.size < countOfOptions) {
            variantlar.add(Random.nextInt(from, to))
        }
        return Question(yigindi, visibleNumber, variantlar.toList())
    }

    override fun getGameSetting(level: Level): GameSetting = when (level) {
        Level.TEST -> GameSetting(10, 5, 50, 8)
        Level.EASY -> GameSetting(10, 10, 70, 60)
        Level.NORMAL -> GameSetting(20, 20, 80, 40)
        Level.HARD -> GameSetting(30, 30, 90, 45)
    }
}