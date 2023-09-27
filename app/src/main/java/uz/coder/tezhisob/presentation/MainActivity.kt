package uz.coder.tezhisob.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.coder.tezhisob.R
import uz.coder.tezhisob.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}