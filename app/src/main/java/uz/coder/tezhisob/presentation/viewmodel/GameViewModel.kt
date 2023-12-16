package uz.coder.tezhisob.presentation.viewmodel

import android.content.Context
import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.coder.tezhisob.R
import uz.coder.tezhisob.domain.*
import javax.inject.Inject

class GameViewModel @Inject constructor(
    private val getGameSettingUseCase:GetGameSettingUseCase,
    private val generateQuestionUseCase:GenerateQuestionUseCase
) : ViewModel() {
    private lateinit var level: Level
    private lateinit var gameSetting: GameSetting
    private var timer: CountDownTimer? = null
    private var countOfRightAnswer: Int = 0
    private var countOfQuestion: Int = 0
    private val _formatted = MutableLiveData<String>()
    val formatted: LiveData<String>
        get() = _formatted
    private val _question = MutableLiveData<Question>()
    val question: LiveData<Question>
        get() = _question
    private val _percentRightOfAnswer = MutableLiveData<Int>()
    val percentRightOfAnswer: LiveData<Int>
        get() = _percentRightOfAnswer
    private val _progressAnswer = MutableLiveData<String>()
    val progressAnswer: LiveData<String>
        get() = _progressAnswer
    private val _enoughRightOfAnswer = MutableLiveData<Boolean>()
    val enoughRightOfAnswer: LiveData<Boolean>
        get() = _enoughRightOfAnswer
    private val _enoughPercentOfAnswer = MutableLiveData<Boolean>()
    val enoughPercentOfAnswer: LiveData<Boolean>
        get() = _enoughPercentOfAnswer
    private val _minPercent = MutableLiveData<Int>()
    val minPercent: LiveData<Int>
        get() = _minPercent
    private val _gameResult = MutableLiveData<GameResult>()
    val gameResult: LiveData<GameResult>
        get() = _gameResult
    fun startGame(level: Level) {
        settingGame(level)
        startTime()
        _minPercent.value = gameSetting.minPercentOfRightAnswer
        generateQuestion()
        updateProgress()
    }
    private fun startTime() {
        timer = object : CountDownTimer(
            gameSetting.timer * MILLI_IN_SECOND,
            MILLI_IN_SECOND
        ) {
            override fun onTick(millisUntilFinished: Long) {
                _formatted.value = formattedTime(millisUntilFinished)
            }

            override fun onFinish() {
                finishGame()
            }
        }.start()
    }
    private fun generateQuestion() {
        _question.value = generateQuestionUseCase(gameSetting.maxSumValue)
    }
    fun chooseUserAnswer(number: Int) {
        val realRightAnswer = question.value?.rightAnswer
        checkAnswer(realRightAnswer, number)

    }
    private fun updateProgress() {
        val percent = calculatePercentOfRightAnswer()
        _percentRightOfAnswer.value = percent
        _progressAnswer.value = String.format(
            "To'g'ri javoblar soni: %s (minimum javoblar %s)",
            countOfRightAnswer,
            gameSetting.minCountOfRightAnswer
        )
        _enoughRightOfAnswer.value = countOfRightAnswer >= gameSetting.minCountOfRightAnswer
        _enoughPercentOfAnswer.value = percent >= gameSetting.minPercentOfRightAnswer
    }
    private fun calculatePercentOfRightAnswer(): Int {
        if (countOfQuestion == 0) {
            return 0
        }
        return ((countOfRightAnswer / countOfQuestion.toDouble()) * 100).toInt()
    }
    private fun checkAnswer(realRightAnswer: Int?, number: Int) {
        if (realRightAnswer == number) {
            countOfRightAnswer++
        }
        countOfQuestion++
        updateProgress()
        generateQuestion()
    }
    private fun finishGame() {
        _gameResult.value = GameResult(
            enoughPercentOfAnswer.value == true && enoughRightOfAnswer.value == true,
            countOfRightAnswer,
            countOfQuestion,
            gameSetting
        )
    }
    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }
    private fun formattedTime(millisUntilFinished: Long): String {
        val second = millisUntilFinished / MILLI_IN_SECOND
        val minute = second / SECOND_IN_MINUTE
        val leftTime = second - (minute * SECOND_IN_MINUTE)
        return String.format("%02d:%02d", minute, leftTime)
    }
    private fun settingGame(level: Level) {
        this.level = level
        gameSetting = getGameSettingUseCase(level)
    }
    companion object {
        private const val MILLI_IN_SECOND = 1000L
        private const val SECOND_IN_MINUTE = 60
    }
}