package uz.coder.tezhisob.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.coder.tezhisob.R
import uz.coder.tezhisob.databinding.FragmentLevelBinding
import uz.coder.tezhisob.domain.Level

class LevelFragment:Fragment() {
    private var _binding: FragmentLevelBinding? = null
    private val binding: FragmentLevelBinding
        get() = _binding?:throw RuntimeException("binding kelmadi")
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
                chengeLevel(Level.TEST)
            }
            oson.setOnClickListener {
                chengeLevel(Level.EASY)
            }
            orta.setOnClickListener {
                chengeLevel(Level.NORMAL)
            }
            qiyin.setOnClickListener {
                chengeLevel(Level.HARD)
            }
        }
    }
    fun chengeLevel(level: Level){
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container,GameFragment.newInstanse(
            level)).addToBackStack(GameFragment.GAME_FRAGMENT).commit()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        const val LEVEL_FRAGMENT = "level_fragment"
        fun newInstance(): Fragment {
            return LevelFragment()
        }
    }
}