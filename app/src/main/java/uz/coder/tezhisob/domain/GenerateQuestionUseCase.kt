package uz.coder.tezhisob.domain

import javax.inject.Inject

class GenerateQuestionUseCase @Inject constructor(private val repository: GameRepository) {
    operator fun invoke(maxSumValue:Int):Question{
        return repository.genereteQuession(maxSumValue, COUNT_OF_OPTIONS)
    }
    companion object{
        const val COUNT_OF_OPTIONS = 6
    }
}