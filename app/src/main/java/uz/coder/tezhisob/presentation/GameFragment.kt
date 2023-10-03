package uz.coder.tezhisob.presentation

import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import uz.coder.tezhisob.R
import uz.coder.tezhisob.databinding.FragmentGameBinding
import uz.coder.tezhisob.domain.GameResult
import uz.coder.tezhisob.domain.Level

class GameFragment:Fragment() {
    private lateinit var level: Level
    private var _binding:FragmentGameBinding? = null
    private val binding:FragmentGameBinding
    get() = _binding?:throw RuntimeException("binding kelmadi")
    private  val viewModel: GameViewModel by lazy {
        ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(requireActivity().application))[GameViewModel::class.java]
    }
    private val listVariant:MutableList<AppCompatButton> by lazy {
        mutableListOf<AppCompatButton>().apply {
            add(binding.var1)
            add(binding.var2)
            add(binding.var3)
            add(binding.var4)
            add(binding.var5)
            add(binding.var6)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(layoutInflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            viewModel.startGame(level)
            for (i in 0 until  listVariant.size){
                viewModel.question.observe(viewLifecycleOwner){
                    listVariant[i].text = it.options[i].toString()
                }
            }
            for (variant in listVariant){
                variant.setOnClickListener {
                    viewModel.chooseUserAnswer(variant.text.toString().toInt())
                }
            }
            viewModel.percentRightOfAnswer.observe(viewLifecycleOwner){
                binding.progress.setProgress(it,true)
            }
            viewModel.enoughRightOfAnswer.observe(viewLifecycleOwner){
                val colorResId = if (it){
                    android.R.color.holo_green_light
                }else{
                    android.R.color.holo_red_light
                }
                val color  = ContextCompat.getColor(requireActivity(),colorResId)
                binding.textView.setTextColor(color)
            }
            viewModel.enoughPercentOfAnswer.observe(viewLifecycleOwner){
                val colorResId = if (it){
                    android.R.color.holo_green_light
                }else{
                    android.R.color.holo_red_light
                }
                val color  = ContextCompat.getColor(requireContext(),colorResId)
                binding.progress.progressTintList = ColorStateList.valueOf(color)
            }
            viewModel.progressAnswer.observe(viewLifecycleOwner){
                binding.textView.text = it
            }
            viewModel.question.observe(viewLifecycleOwner){
                yigindi.text = it.yigindi.toString()
                answer.text = it.visableNumber.toString()
            }
            viewModel.formatted.observe(viewLifecycleOwner){
                vaqt.text = it.toString()
            }
        }
        viewModel.minPercent.observe(viewLifecycleOwner){
            binding.progress.secondaryProgress = it
        }
        viewModel.gameResult.observe(viewLifecycleOwner){
            gameOver(it)
        }
    }

    private fun gameOver(gameResult: GameResult) {
        findNavController().navigate(R.id.action_gameFragment_to_gameEndFragment,Bundle().apply {
            putSerializable(GameEndFragment.KEY_GAMERESULT,gameResult)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        chooseLevel()
    }
    private fun chooseLevel(){
        level = arguments?.getSerializable(KEY_LEVEL) as Level
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object{
        const val KEY_LEVEL = "key_level"
    }
}