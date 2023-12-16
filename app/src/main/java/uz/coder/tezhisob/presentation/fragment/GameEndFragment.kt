package uz.coder.tezhisob.presentation.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.coder.tezhisob.R
import uz.coder.tezhisob.databinding.FragmentGameEndBinding
import uz.coder.tezhisob.domain.GameResult

class GameEndFragment: Fragment() {
    private var _binding: FragmentGameEndBinding? = null
    private val binding: FragmentGameEndBinding
        get() = _binding?:throw RuntimeException("binding init")
    private lateinit var gameResult: GameResult

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        foundGameResult()
    }

    private fun foundGameResult() {
        gameResult = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getSerializable(KEY_GAMERESULT,GameResult::class.java)?:throw RuntimeException("")
        }else{
            requireArguments().getSerializable(KEY_GAMERESULT) as GameResult
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameEndBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            if (gameResult.winner){
                emoji.setImageResource(R.drawable.ic_smile)
            }else{
                emoji.setImageResource(R.drawable.ic_sad)
            }
            buttonRetry.setOnClickListener {
                retry()
            }
            minBall.text  =String.format(getString(R.string.required_score,gameResult.gameSetting.minCountOfRightAnswer.toString()))
            score.text  =String.format(getString(R.string.score_answer,gameResult.countOfRightAnswer.toString()))
            requiredPercent.text  =String.format(getString(R.string.required_percent,gameResult.gameSetting.minPercentOfRightAnswer.toString()))
            scorePercent.text  =String.format(getString(R.string.to_gri_javoblar_foizda_s_minumum_s),((gameResult.countOfRightAnswer /gameResult.countOfQuession.toDouble()) * 100).toInt().toString())
        }
    }

    private fun retry() {
        findNavController().popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
         const val KEY_GAMERESULT = "game_result"
    }
}