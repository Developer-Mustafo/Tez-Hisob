package uz.coder.tezhisob.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.coder.tezhisob.databinding.FragmentGameBinding
import uz.coder.tezhisob.domain.Level

class GameFragment:Fragment() {
    private var _binding:FragmentGameBinding? = null
    private val binding:FragmentGameBinding
    get() = _binding?:throw RuntimeException("binding kelmadi")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object{
        private const val TAG = "GameFragment"
        fun newInstanse(level: Level):Fragment{
            Log.d(TAG, "newInstanse: $level")
            return GameFragment()
        }
    }
}