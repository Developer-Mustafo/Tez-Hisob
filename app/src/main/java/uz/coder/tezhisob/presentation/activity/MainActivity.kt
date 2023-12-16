package uz.coder.tezhisob.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.coder.tezhisob.R
import uz.coder.tezhisob.databinding.ActivityMainBinding
import uz.coder.tezhisob.di.AppComponent
import uz.coder.tezhisob.presentation.App

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}