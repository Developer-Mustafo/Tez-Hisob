package uz.coder.tezhisob.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.coder.tezhisob.R
import uz.coder.tezhisob.databinding.FragmentStartBinding

class StartFragment: Fragment() {
    private var _binding:FragmentStartBinding? = null
    private val binding:FragmentStartBinding
        get() = _binding?:throw RuntimeException("binding kelmadi")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            tushundim.setOnClickListener {
                chooseLevelFragment()
            }
        }
    }

    private fun chooseLevelFragment() {
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container,LevelFragment.newInstance()).commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): Fragment {
            return StartFragment()
        }
    }
}