package com.pefacel.loginformapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.pefacel.loginformapp.databinding.ActivityLoginBinding
import kotlin.math.min

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextPassword.addTextChangedListener { watcher ->
            println(watcher);

            binding.button.isEnabled = passwordIsAllowed(watcher.toString())
        }

        binding.button.setOnClickListener{

            startActivity(Intent(this, ResultActivity::class.java))

        }

    }

    fun minLength(text: String, number: Int): Boolean {

        if (text.length > number) return true

        return false
    }

    fun passwordIsAllowed(password: String): Boolean {

        if (minLength(password, 4) && isUppercase(password)) {
            return true
        }
        return false
    }

    fun isUppercase(text: String): Boolean {

        var hasUpper = false

        val chars: CharArray = text.toCharArray()
        for (char in chars) {
            if (char.isUpperCase()) hasUpper = true
        }

        return hasUpper

    }


}