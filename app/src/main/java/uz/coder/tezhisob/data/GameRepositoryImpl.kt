package uz.coder.tezhisob.data

import uz.coder.tezhisob.domain.GameRepository
import uz.coder.tezhisob.domain.GameSetting
import uz.coder.tezhisob.domain.Question
import uz.coder.tezhisob.presentation.fragment.GameFragment
import javax.inject.Inject
import kotlin.random.Random

class GameRepositoryImpl @Inject constructor():GameRepository {
    private val minSumValue = 2
    private val minSumValueAnswer = 1
    override fun genereteQuession(maxSumValue: Int, countOfOptions: Int): Question {
        val yigindi = Random.nextInt(minSumValue, maxSumValue+1) //27
        val visibleNumber = Random.nextInt(minSumValueAnswer, yigindi) //15
        val variantlar = HashSet<Int>()
        val rightAnswer = yigindi - visibleNumber
        variantlar.add(rightAnswer)
        val from = kotlin.math.max(rightAnswer - countOfOptions, minSumValue)//1
        val to = kotlin.math.min(maxSumValue - 1, rightAnswer + countOfOptions)
        while (variantlar.size < countOfOptions) {
            variantlar.add(Random.nextInt(from, to))
        }
        return Question(yigindi, visibleNumber, variantlar.toList())
    }

    override fun getGameSetting(string: String): GameSetting = when (string) {
        GameFragment.TEST -> GameSetting(10, 5, 50, 8)
        GameFragment.EASY -> GameSetting(10, 10, 70, 60)
        GameFragment.NORMAL -> GameSetting(20, 20, 80, 40)
        GameFragment.HARD -> GameSetting(30, 30, 90, 45)
        else->GameSetting(10, 5, 50, 8)
    }
}