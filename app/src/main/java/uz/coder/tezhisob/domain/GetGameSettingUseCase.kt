package uz.coder.tezhisob.domain

class GetGameSettingUseCase(private val repository: GameRepository) {
    operator fun invoke(level: Level):GameSetting{
        return repository.getGameSetting(level)
    }
}