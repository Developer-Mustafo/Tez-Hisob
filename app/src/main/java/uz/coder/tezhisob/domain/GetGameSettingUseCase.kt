package uz.coder.tezhisob.domain

import javax.inject.Inject

class GetGameSettingUseCase @Inject constructor(private val repository: GameRepository) {
    operator fun invoke(string: String):GameSetting{
        return repository.getGameSetting(string)
    }
}