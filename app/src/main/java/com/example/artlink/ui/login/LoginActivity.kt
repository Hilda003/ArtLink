package com.example.artlink.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.artlink.HomeFragment
import com.example.artlink.MainActivity
import com.example.artlink.R
import com.example.artlink.databinding.ActivityLoginBinding
import com.example.artlink.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.registerText.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}