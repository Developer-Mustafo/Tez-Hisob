package uz.coder.tezhisob.domain

import javax.inject.Inject

class GetGameSettingUseCase @Inject constructor(private val repository: GameRepository) {
    operator fun invoke(level: Level):GameSetting{
        return repository.getGameSetting(level)
    }
}