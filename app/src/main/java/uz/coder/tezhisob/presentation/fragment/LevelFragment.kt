package uz.coder.tezhisob.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.coder.tezhisob.R
import uz.coder.tezhisob.databinding.FragmentLevelBinding

class LevelFragment:Fragment() {
    private var _binding: FragmentLevelBinding? = null
    private val binding: FragmentLevelBinding
        get() = _binding?:throw RuntimeException("binding init")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLevelBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            test.setOnClickListener {
                changeLevel(GameFragment.TEST)
            }
            oson.setOnClickListener {
                changeLevel(GameFragment.EASY)
            }
            orta.setOnClickListener {
                changeLevel(GameFragment.NORMAL)
            }
            qiyin.setOnClickListener {
                changeLevel(GameFragment.HARD)
            }
        }
    }
    private fun changeLevel(str:String){
        findNavController().navigate(R.id.action_levelFragment_to_gameFragment,Bundle().apply {
            putString(GameFragment.KEY_TEST,str)
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}