package uz.coder.tezhisob.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.coder.tezhisob.R
import uz.coder.tezhisob.databinding.FragmentLevelBinding
import uz.coder.tezhisob.domain.Level

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
                changeLevel(Level.TEST)
            }
            oson.setOnClickListener {
                changeLevel(Level.EASY)
            }
            orta.setOnClickListener {
                changeLevel(Level.NORMAL)
            }
            qiyin.setOnClickListener {
                changeLevel(Level.HARD)
            }
        }
    }
    private fun changeLevel(level: Level){
        findNavController().navigate(R.id.action_levelFragment_to_gameFragment,Bundle().apply {
            putSerializable(GameFragment.KEY_LEVEL,level)
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}