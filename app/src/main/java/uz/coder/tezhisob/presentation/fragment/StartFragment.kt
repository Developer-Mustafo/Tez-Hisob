package uz.coder.tezhisob.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.coder.tezhisob.R
import uz.coder.tezhisob.databinding.FragmentStartBinding

class StartFragment: Fragment() {
    private var _binding:FragmentStartBinding? = null
    private val binding:FragmentStartBinding
        get() = _binding?:throw RuntimeException("binding init")
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
        findNavController().navigate(R.id.action_startFragment_to_levelFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}